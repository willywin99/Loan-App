package com.example.loanapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {
    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        var u1 = User.withUsername("sales").password("password").roles("SALES").build();
        var u2 = User.withUsername("approver").password("password").roles("APPROVER").build();
        return new InMemoryUserDetailsManager(u1, u2);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/","/index.html","/static/**").permitAll()
                .requestMatchers("/h2-console/**").permitAll()
                .requestMatchers("/api/applications/**").authenticated()
            )
            .httpBasic();
        http.headers().frameOptions().sameOrigin();
        return http.build();
    }

    @Bean
    @SuppressWarnings("deprecation")
    public static NoOpPasswordEncoder passwordEncoder() {
        return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
    }
}
