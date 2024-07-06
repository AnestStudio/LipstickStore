package org.anest.mystore.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(authorizeRequests -> authorizeRequests
                        // STATIC
                        .requestMatchers("/css/**", "/images/**", "/js/**", "/webfonts/**").permitAll()
                        // URL
                        .requestMatchers("/", "/login", "/logout").permitAll()
                        .requestMatchers("/products/**").permitAll()
                        .requestMatchers("/cart/**").permitAll()
                        .requestMatchers("/checkout").hasRole("MEMBER")
                        .requestMatchers("/user/**").hasRole("MEMBER")
                        .requestMatchers("/admin/**").hasRole("ADMIN")
                        // API
                        .requestMatchers("/api/public/**").permitAll()
                        // OTHER
                        .anyRequest().permitAll()
                        //.anyRequest().authenticated()
                )
                .formLogin(formLogin -> formLogin
                        .loginPage("/login")
                        .usernameParameter("username")
                        .passwordParameter("password")
//                        .failureUrl("/login?error=true")
//                        .failureHandler((request, response, e) -> {
//                            if (e instanceof UsernameNotFoundException) {
//                                response.sendRedirect("/error?error=true");
//                            } else if (e instanceof DisabledException) {
//                                response.sendRedirect("/error?error=false");
//                            } else {
//                                response.sendRedirect("/error");
//                            }
//                        })
                        .successHandler(authenticationSuccessHandler())
                        .failureHandler(authenticationFailureHandler())
                )
                .exceptionHandling(exceptionHandling -> exceptionHandling
                        .accessDeniedHandler(accessDeniedHandler())
                )
//                .exceptionHandling(exceptionHandling -> exceptionHandling
//                        .authenticationEntryPoint((request, response, authException) -> {
//                            if (authException instanceof UsernameNotFoundException) {
//                                response.sendRedirect("/error?error=true");
//                            } else if (authException instanceof DisabledException) {
//                                response.sendRedirect("/error?error=false");
//                            } else {
//                                response.sendRedirect("/error");
//                            }
//                        })
//                        .accessDeniedHandler((request, response, accessDeniedException) ->
//                                response.sendRedirect("/access-denied")
//                        )
//                )
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/login?logout")
                        .invalidateHttpSession(true)
                        .deleteCookies("JSESSIONID")
                )
                .rememberMe(rememberMe -> rememberMe
                        .key("uniqueAndSecret")
                        .tokenValiditySeconds(86400)
                )
                .sessionManagement(sessionManagement -> sessionManagement
                        .invalidSessionUrl("/login")
                        .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
                );
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationFailureHandler authenticationFailureHandler() {
        return new CustomAuthenticationFailureHandler();
    }

    @Bean
    public AuthenticationSuccessHandler authenticationSuccessHandler() {
        return new CustomAuthenticationSuccessHandler();
    }

    @Bean
    public AccessDeniedHandler accessDeniedHandler() {
        return new CustomAccessDeniedHandler();
    }
}