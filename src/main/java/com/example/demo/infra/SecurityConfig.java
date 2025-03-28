package com.example.demo.infra;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf
                        .ignoringRequestMatchers("/h2-console/**", "/usuario/**", "/api/kafka/**")
                )
                .headers(headers -> headers
                        .frameOptions(HeadersConfigurer.FrameOptionsConfig::sameOrigin
                        )
                )
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/h2-console/**").permitAll()
                        .requestMatchers(HttpMethod.GET, "/usuario/").permitAll()
                        .requestMatchers(HttpMethod.GET, "/usuario/{id}").permitAll()
                        .requestMatchers(HttpMethod.POST, "/usuario/").permitAll()
                        .requestMatchers(HttpMethod.PUT, "/usuario/{id}").permitAll()
                        .requestMatchers(HttpMethod.DELETE, "/usuario/{id}").permitAll()
                        .requestMatchers(HttpMethod.POST, "/api/kafka/send").permitAll()
                        .anyRequest().authenticated()
                );

        return http.build();
    }
}