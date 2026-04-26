package com.sankhamtech.vediclms.configuration;

/**
 * SecurityConfig:
 *
 * This is a Spring configuration class that defines the application's security setup.
 *
 * - @Configuration tells Spring to load this class at startup and process its bean definitions.
 * - @EnableWebSecurity enables Spring Security and activates the web security framework.
 *
 * - The @Bean method defines a SecurityFilterChain, which is registered in the Spring context.
 *   This filter chain intercepts every incoming HTTP request.
 *
 * - Each request passes through the filter chain, where:
 *     1. Authentication is handled (e.g., OAuth login with Google)
 *     2. Authorization rules are applied (permitAll vs authenticated)
 *
 * - Based on this configuration, requests are either:
 *     ✔ Allowed to proceed to controllers
 *     ✖ Blocked or redirected (e.g., to login)
 *
 * In short: This class acts as the central gatekeeper that controls access to the application.
 */


import com.sankhamtech.vediclms.authentication.handler.CustomFailureHandler;
import com.sankhamtech.vediclms.authentication.handler.CustomSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.context.annotation.Bean;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private CustomSuccessHandler customSuccessHandler;

    @Autowired
    private CustomFailureHandler customFailureHandler;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/public/**", "/oauth2/**", "/css/**").permitAll()
                        .anyRequest().authenticated()
                )
                .oauth2Login(oauth -> oauth
                        .successHandler(customSuccessHandler)
                        .failureHandler(customFailureHandler)
                );

        return http.build();
    }
}