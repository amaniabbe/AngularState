package com.services.user;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import com.services.user.filters.ApplicationKeyFilter;
import com.services.user.filters.AuthorizationFilter;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;


@SpringBootApplication
public class UserApplication {

    @Value("${app-key}")
    private String applcationKey;

    @Value("${app-token}")
    private String applcationToken;

    public static void main(String[] args)
    {
        SpringApplication.run(UserApplication.class, args);

    }


    @Bean
    OpenAPI customApi(@Value("${application-description}") String description, @Value("${application-version}") String version)
    {
        return new OpenAPI()
            .info(new Info()
                .title("User Service")
                .description(description)
                .version(version)
                .termsOfService("http://swagger.io/terms/")
                .license(new License().name("Apache 2.0").url("http://springdoc.org")))
            .components(new Components()
                .addSecuritySchemes("app-key", new SecurityScheme()
                    .name("appKey")
                    .type(SecurityScheme.Type.APIKEY)
                    .in(SecurityScheme.In.HEADER))
                .addSecuritySchemes("my-token", new SecurityScheme()
                    .name("appToken")
                    .type(SecurityScheme.Type.APIKEY)
                    .in(SecurityScheme.In.HEADER)))
                .addSecurityItem(new SecurityRequirement().addList("my-token").addList("app-key"))
            .addServersItem(new Server().url("http://localhost:8080"));
            
       
           

    }

    @Bean
    FilterRegistrationBean<AuthorizationFilter> authorizationFilter()
    {         
        FilterRegistrationBean<AuthorizationFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new AuthorizationFilter(applcationToken));
        registrationBean.addUrlPatterns("/api/*");
        registrationBean.setOrder(2);

        return registrationBean;
    }

    @Bean
    FilterRegistrationBean<ApplicationKeyFilter> applicationKeyFilter()
    {         
        FilterRegistrationBean<ApplicationKeyFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new ApplicationKeyFilter(applcationKey));
        registrationBean.addUrlPatterns("/api/*");
        registrationBean.setOrder(1);

        return registrationBean;
    }

  
}
