package com.nhnacademy.taskapi.project.taskapi.config;

import com.nhnacademy.taskapi.project.taskapi.auth.LoginSuccessHandler;
import com.nhnacademy.taskapi.project.taskapi.service.SignInService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

//@EnableWebSecurity(debug = true)
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .anyRequest().permitAll()
                .and()
            .formLogin()
                .usernameParameter("id")
                .passwordParameter("pwd")
                .loginPage("/login")
                .loginProcessingUrl("/signin")
                .defaultSuccessUrl("/loginSuccess")
                .failureUrl("/loginFail")
                .successHandler(loginSuccessHandler(null))
                .and()
            .logout()
                .logoutUrl("/logout")
                .and()
            .csrf()
                .and()
            .sessionManagement()
                .sessionFixation()
                    .none()
                .and()
            .headers()
                .defaultsDisabled()
                .frameOptions().sameOrigin()
                .and()
            .exceptionHandling()
                .accessDeniedPage("/error/403")
                .and();
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider(null));
    }

    @Bean
    public AuthenticationProvider authenticationProvider(SignInService signInService) {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService((UserDetailsService) signInService);
        authenticationProvider.setPasswordEncoder(passwordEncoder());

        return authenticationProvider;
    }

    private PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    private AuthenticationSuccessHandler loginSuccessHandler(RedisTemplate<String, String> redisTemplate) {
        return new LoginSuccessHandler(redisTemplate);
    }
}
