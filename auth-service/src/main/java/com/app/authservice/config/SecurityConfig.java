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

// REMOVED all CORS imports and corsConfigurationSource() bean.
// CORS is owned entirely by the API Gateway.
// Having it here caused duplicate Access-Control-Allow-Origin headers.
//
// DELETED IMPORTS (do not re-add):
// import org.springframework.web.cors.CorsConfiguration;
// import org.springframework.web.cors.CorsConfigurationSource;
// import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
// import java.util.List;

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
            // FIX: cors MUST be disabled here.
            // spring-boot-starter-oauth2-client on the classpath causes Spring Security
            // to auto-register a CorsFilter bean. If you call .cors() with any
            // configuration here, that filter fires and adds its own
            // Access-Control-Allow-Origin header on top of the Gateway's header.
            // Result: browser sees 5 identical values and blocks the request.
            .cors(cors -> cors.disable())
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
                    "/login/oauth2/**",          // OAuth2 redirect URIs
                    "/oauth2/**",                // OAuth2 authorization endpoint
                    "/api/auth/oauth2/success",  // Your OAuth2 success handler
                    "/swagger-ui/**",
                    "/swagger-ui.html",
                    "/v3/api-docs/**",
                    "/v3/api-docs",
                    "/api-docs/**"
                ).permitAll()
                .anyRequest().authenticated())
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

    // corsConfigurationSource() bean is DELETED.
    // Do not add it back. Do not add @CrossOrigin to any controller.
    // Any Spring-side CORS config will duplicate the Gateway's header.
}
