package com.service.session.session.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorizeRequests ->
                        authorizeRequests
                                .requestMatchers("/public/**").permitAll() // Public endpoints
                                .anyRequest().authenticated() // All other endpoints require authentication
                )
                .formLogin(withDefaults()); // Default form login configuration

        return http.build();
    }

    @Bean
    public SecurityFilterChain customSecurityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(authorizeRequests ->
                authorizeRequests
                    .requestMatchers("/admin/**").hasRole("ADMIN") // Specific admin endpoints
                    .requestMatchers("/user/**").hasRole("USER") // Specific user endpoints
                    .anyRequest().authenticated()
            )
            .httpBasic(withDefaults()); // Basic authentication for custom chain

        return http.build();
    }
}

