package com.jdai.SpringSecurityDemo.config;

import org.springframework.security.config.annotation.SecurityBuilder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    //authentication rules
    @Override
    public void configure(HttpSecurity http) throws Exception {
//        super.configure(web);
        http.authorizeRequests().antMatchers("/").permitAll()
                .antMatchers("/level1/**").hasRole("role1")
                .antMatchers("/level2/**").hasRole("role2")
                .antMatchers("/level3").hasRole("role3");
        //turn on login
        http.formLogin();
        //1. /login
        //2. redirect to login/error if login failed
        //3. logout

    }

    //authorization rules
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //super.configure(auth);
        auth.inMemoryAuthentication()
                .withUser("user1").password("password1").roles("role1")
                .and()
                .withUser("user2").password("password2").roles("role2")
                .and()
                .withUser("user3").password("password3").roles("role3");
    }
}
