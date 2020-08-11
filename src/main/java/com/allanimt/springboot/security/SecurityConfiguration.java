package com.allanimt.springboot.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    private final String[] PUBLIC_ENDPOINTS = {
            "/api/v1/auth/**"
    };

    @Bean
    @Override
    public AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Bean
    public AuthFilter authFilter(){
        return new AuthFilter();
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {

        //Cors and csrf are disabled, because we dont have cookies..(it's just an API)
        httpSecurity.cors().and().csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS) //We use JWT, i don't need sessions
                .and()
                .authorizeRequests()
                .antMatchers(PUBLIC_ENDPOINTS).permitAll() // all url from  PUBLIC_ENTRYPOTS auhorised
                .anyRequest().authenticated() //Other urls need authentication
                .and().addFilterBefore(authFilter(), UsernamePasswordAuthenticationFilter.class);
    }
}
