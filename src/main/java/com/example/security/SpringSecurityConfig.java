package com.example.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/", "/login").permitAll() // public access
        .antMatchers("/home").authenticated() // 인증된 사용자만 가능
             .and().csrf().disable()
                .formLogin().loginPage("/login")
                    .defaultSuccessUrl("/home")
                        .usernameParameter("username").passwordParameter("password");
    }
}
