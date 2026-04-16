package com.app.authservice.config;

import com.app.authservice.security.JwtFilter;
import com.app.authservice.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.security.authentication.*;
import org.springframework.security.config.annotation.authentication.configuration.*;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

//  REMOVED: CorsConfiguration, CorsConfigurationSource, UrlBasedCorsConfigurationSource, List
//    CORS is handled entirely by API Gateway — having it here caused duplicate headers.

@Configuration
public class SecurityConfig {

    private final JwtFilter jwtFilter;
    private final CustomUserDetailsService uds;

    @Autowired
    public SecurityConfig(JwtFilter jwtFilter, CustomUserDetailsService uds) {
        this.jwtFilter = jwtFilter;
        this.uds = uds;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
            // REMOVED: .cors(cors -> cors.configurationSource(corsConfigurationSource()))
            //    Do NOT configure CORS here at all — Gateway handles it.
            //    If you leave cors() configured in the auth service, Spring Security will add
            //    its own Access-Control-Allow-Origin header on top of the Gateway's header,
            //    producing the "contains multiple values" error in the browser.
            .cors(cors -> cors.disable())   // ← Explicitly disable — let Gateway own CORS
            .csrf(c -> c.disable())
            .sessionManagement(s ->
                s.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .authorizeHttpRequests(a -> a
                .requestMatchers(
                    "/",
                    "/error",
                    "/api/auth/signup",
                    "/api/auth/login",
                    "/api/auth/validate",
                    "/login/oauth2/**",         //  OAuth2 redirect URIs must be permitted
                    "/oauth2/**",               //  OAuth2 authorization endpoint
                    "/api/auth/oauth2/success", //  Your OAuth2 success handler
                    "/swagger-ui/**",
                    "/swagger-ui.html",
                    "/v3/api-docs/**",
                    "/v3/api-docs",
                    "/api-docs/**"
                ).permitAll()
                .anyRequest().authenticated())
            //  Re-enabled oauth2Login so Google OAuth actually works
            .oauth2Login(oauth2 -> oauth2
                .defaultSuccessUrl("/api/auth/oauth2/success", true)
            )
            .addFilterBefore(jwtFilter,
                UsernamePasswordAuthenticationFilter.class)
            .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authManager(
            AuthenticationConfiguration cfg) throws Exception {
        return cfg.getAuthenticationManager();
    }

    //  REMOVED: corsConfigurationSource() bean entirely.
    //    Keeping it here — even without .cors() in the filter chain — risks Spring
    //    auto-detecting and applying it. Delete the whole method.
}
