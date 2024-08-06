package com.CollabFusion.COLLABFUSIONPROEJCT.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                // .authorizeHttpRequests(auth -> auth
                // .requestMatchers("/").permitAll()
                // .requestMatchers("/contact").permitAll()
                // .requestMatchers("/store/**").permitAll()
                // .requestMatchers("/register").permitAll()
                // .requestMatchers("/login").permitAll()
                // .requestMatchers("/logout").permitAll()
                // .anyRequest().authenticated()
                // )
                // .formLogin(form -> form
                // .defaultSuccessUrl("/", true))
                // .logout(config -> config.logoutSuccessUrl("/"))
                // .build();
                .authorizeHttpRequests(auth -> auth
                .requestMatchers("/").permitAll() // Permits all requests to the root
                .requestMatchers("/contact").permitAll() // Permits all requests to the /contact page
                .requestMatchers("/store/**").permitAll() // Permits all requests to URLs starting with /store
                .requestMatchers("/register").permitAll() // Permits all requests to the /register page
                .requestMatchers("/login").permitAll() // Permits all requests to the /login page
                .requestMatchers("/logout").permitAll() // Permits all requests to the /logout page
                .anyRequest().authenticated() // Requires authentication for all other requests
                )
                .formLogin(form -> form
                .loginPage("/login") // Specifies the custom login page URL
                .defaultSuccessUrl("/home", true) // Redirects to /home after successful login
                .failureUrl("/login?error=true") // Redirects back to login page on failure
                .permitAll() // Permits all requests to the login page
                )
                .logout(config -> config
                .logoutSuccessUrl("/") // Redirects to the root page after logout
                .permitAll() // Permits all requests to the logout page
                )
                .build();

    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
