package com.global.spring_security_demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfiguration {

    
    // protected void configure(HttpSecurity http)throws Exception{
    //     http.httpBasic(null).and().authorizeHttpRequests().antMatchers("/user/**").hasRole("USER").
    //     antMatchers("/role/**").hasRole("ADMIN").and().csrf().disable();

    // }


    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    protected void configure(AuthenticationManagerBuilder auth)throws Exception{

        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
    }
        

 
}
