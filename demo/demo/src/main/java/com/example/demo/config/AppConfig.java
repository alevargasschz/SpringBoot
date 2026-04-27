package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.demo.security.CustomUserDetailsService;
import com.example.demo.security.filters.CustomSecurityFilter;

@Configuration
@EnableWebSecurity(debug = true)
@EnableMethodSecurity
public class AppConfig {
        @Bean
        public UserDetailsService userDetailsService() {
                return new CustomUserDetailsService();
        }

        @Bean
        public PasswordEncoder passwordEncoder() {
                return new BCryptPasswordEncoder();
        }

        @Bean
        public CustomSecurityFilter customSecurityFilter() {
                return new CustomSecurityFilter();
        }

        @Bean
        @Order(1)
        public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
                return http
                                .securityMatcher("/**", "/h2-console/**")
                                .csrf(csrf -> csrf.ignoringRequestMatchers("/h2-console/**"))
                                .headers(headers -> headers.frameOptions(frame -> frame.sameOrigin()))
                                .authorizeHttpRequests(authz -> authz
                                                .requestMatchers("/public/**", "/h2-console/**").permitAll()
                                                .requestMatchers("/login", "/css/**", "/js/**").permitAll()
                                                .anyRequest().authenticated())
                                .formLogin(form -> form
                                                .loginPage("/login") // URL personalizada para mostrar login
                                                .loginProcessingUrl("/login") // URL que procesa el login
                                                .defaultSuccessUrl("/users", true) // Redirección después del login
                                                                                   // exitoso
                                                .failureUrl("/login?error") // Redirección en caso de error
                                                .usernameParameter("username") // Nombre del campo username
                                                .passwordParameter("password") // Nombre del campo password
                                                .permitAll())
                                .logout(logout -> logout
                                                .logoutUrl("/logout")
                                                .logoutSuccessUrl("/login?logout")
                                                .permitAll())
                                .build();
        }

        @Bean
        @Order(2)
        public SecurityFilterChain apiSecurityFilterChain(HttpSecurity http) throws Exception {
                return http
                                .securityMatcher("/example/**")
                                .csrf(csrf -> csrf.disable())
                                .addFilterBefore(customSecurityFilter(), UsernamePasswordAuthenticationFilter.class)
                                .authorizeHttpRequests(authz -> authz
                                                .requestMatchers("/example/public/**").permitAll()
                                                .anyRequest().authenticated())
                                .build();
        }

        @Bean
        @Order(3)
        public SecurityFilterChain restSecurityFilterChain(HttpSecurity http) throws Exception {
                return http
                                .securityMatcher("/rest/**")
                                .csrf(csrf -> csrf.disable())
                                .addFilterBefore(customSecurityFilter(), UsernamePasswordAuthenticationFilter.class)
                                .authorizeHttpRequests(authz -> authz
                                                .requestMatchers("/rest/public/**", "/rest/auth/login").permitAll()
                                                .anyRequest().authenticated())
                                .sessionManagement(t -> t.sessionCreationPolicy(SessionCreationPolicy.STATELESS)) // No
                                                                                                                  // tener
                                                                                                                  // sesiones,
                                                                                                                  // stateful
                                .build();
        }
}
