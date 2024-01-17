package com.services.user.filters;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import org.springframework.web.filter.OncePerRequestFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthorizationFilter extends OncePerRequestFilter{

    private String authKey;

    public AuthorizationFilter(String authKey)
    {   
        this.authKey = authKey;
    }

    @Override
    public void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws IOException, ServletException {
            
                String key = request.getHeader("appToken");

                if(key != null)
                {
                    if( !key.equals(authKey))
                    {
                        
                        response.sendError(HttpServletResponse.SC_UNAUTHORIZED , "Unauthorized access token");
                        return;
                        
                    }
                }
                else
                {
                    response.sendError(HttpServletResponse.SC_FORBIDDEN , "Missing access token");
                    return;
                }

                chain.doFilter(request, response);           
    }
}
