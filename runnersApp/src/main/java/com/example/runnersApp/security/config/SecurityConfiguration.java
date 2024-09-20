package com.example.runnersApp.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

import static com.example.runnersApp.model.Permission.*;
import static com.example.runnersApp.model.Role.ADMIN;
import static com.example.runnersApp.model.Role.USER;
import static org.springframework.http.HttpMethod.*;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
    private final AuthenticationProvider authenticationProvider;
    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    public SecurityConfiguration(
            JwtAuthenticationFilter jwtAuthenticationFilter,
            AuthenticationProvider authenticationProvider
    ) {
        this.authenticationProvider = authenticationProvider;
        this.jwtAuthenticationFilter = jwtAuthenticationFilter;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf->csrf.disable())
                //Any requests to /auth/** are allowed without authentication.
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/auth/**")
                        .permitAll()
                        .requestMatchers("/content/**").hasAnyRole(ADMIN.name(),USER.name())

                        .requestMatchers(GET,"/content/**").hasAnyAuthority(ADMIN_READ.name(),USER_READ.name())
                        .requestMatchers(POST,"/content/**").hasAuthority(USER_CREATE.name())
                        .requestMatchers(PUT,"/content/**").hasAuthority(USER_UPDATE.name())
                        .requestMatchers(DELETE,"/content/**").hasAnyAuthority(ADMIN_DELETE.name(),USER_DELETE.name())

                        .requestMatchers("/user/**").hasAnyRole(ADMIN.name(),USER.name())

                        .requestMatchers(GET,"/user/**").hasAuthority(ADMIN_READ.name())
                        .requestMatchers(POST,"/user/**").hasAuthority(USER_CREATE.name())
                        .requestMatchers(PUT,"/user/**").hasAuthority(USER_UPDATE.name())
                        .requestMatchers(DELETE,"/user/**").hasAnyAuthority(ADMIN_DELETE.name(),USER_DELETE.name())

                        .anyRequest().authenticated()
                )
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
    //configures Cross-Origin Resource Sharing (CORS), controls how resources can be shared across different domains.
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(List.of("http://localhost:8081"));
        configuration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE"));
        configuration.setAllowedHeaders(List.of("Authorization", "Content-Type"));

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}