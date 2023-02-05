package com.example.dobaerangshop.global.config;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity(debug = true)
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http
                .authorizeRequests(request->
                        request.antMatchers("/", "/register","/css/**", "/js/**", "/image/**")
                                .permitAll()
                                .anyRequest().authenticated()
                )
                .formLogin(login->
                        login.loginPage("/login")
                                .permitAll()
                                .defaultSuccessUrl("/", false)
                                .failureUrl("/login-error")
                )
                .logout(logout->
                        logout.logoutSuccessUrl("/"))
                .exceptionHandling(error->
                        error.accessDeniedPage("/access-denied")
                );

        return http.build();
    }

    /**
     * 경로를 무시하기 때문에 security 에서 각종 공격에 대해 보호해주지 않음
     * 그러므로 HttpSecurity 의 permitAll()에서 설정해주는게 좋음
     */
    @Bean
    public WebSecurityCustomizer webSecurityCustomizer(){
        return (web -> {
           web.ignoring().requestMatchers(
                   PathRequest.toStaticResources().atCommonLocations()
           );
        });
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
