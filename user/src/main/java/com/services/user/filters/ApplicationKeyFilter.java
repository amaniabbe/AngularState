package com.services.user.filters;

import java.io.IOException;
import org.springframework.web.filter.OncePerRequestFilter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ApplicationKeyFilter extends OncePerRequestFilter {

    private String _applicationKey;

    public ApplicationKeyFilter(String applicationKey)
    {   
        _applicationKey = applicationKey;
    }

    @Override
    public void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        
                String appKey = request.getHeader("appKey");
                
                if(appKey != null)
                {
                    if( !appKey.equals(_applicationKey))
                    {
                        response.sendError(HttpServletResponse.SC_FORBIDDEN , "Unauthorized access key");
                        return;
                    }
                }
                else
                {
                    
                    response.sendError(HttpServletResponse.SC_FORBIDDEN , "Missing access key");
                    return;
                }

                chain.doFilter(request, response); 
        
    }
    
    
}
