package com.softium.assignment.web.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import static java.lang.Boolean.TRUE;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class DefaultSecurityConfig extends WebSecurityConfigurerAdapter {

    private final Environment environment;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().anyRequest().permitAll()
                .and()
                .formLogin().disable()
                .csrf().disable()
                .httpBasic().disable();

        if (TRUE.toString().equalsIgnoreCase(environment.getProperty("spring.h2.console.enabled"))) {
            http.headers().frameOptions().disable();
        }
    }
}
