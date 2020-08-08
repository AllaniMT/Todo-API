package com.allanimt.springboot.security;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    private final String[] PUBLIC_ENTRYPOINTS = {
            "/api/v1/auth/**"
    };

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {

        //Cors and csrf are disabled, because we dont have cookies..(it's just an API)
        httpSecurity.cors().and().csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS) //We use JWT, i don't need sessions
                .and()
                .authorizeRequests()
                .antMatchers(PUBLIC_ENTRYPOINTS).permitAll() // all url from  PUBLIC_ENTRYPOTS auhorised
                .anyRequest().authenticated() //Other urls need authentication
                .and().httpBasic();
    }
}
