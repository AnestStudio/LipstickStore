package org.anest.mystore.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

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
                        .successHandler(new CustomAuthenticationSuccessHandler())
                        .failureUrl("/login?error=true")
                )
                .rememberMe(rememberMe -> rememberMe
                        .key("uniqueAndSecret")
                        .tokenValiditySeconds(86400)
                )
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/login?logout")
                        .invalidateHttpSession(true)
                        .deleteCookies("JSESSIONID")
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
}