package com.skp.analog.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.skp.analog.user.service.UserService;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    
     @Autowired 
     UserService userService;
    
     @Override
     protected void configure(HttpSecurity http) throws Exception {
          http
               .csrf().disable()
               .authorizeRequests()
                    .antMatchers("/loginMain").permitAll()
                    .antMatchers("/user/login").permitAll()
                    .antMatchers("/user").permitAll()//hasAuthority("SUPER")
                    .antMatchers("/admin").permitAll()//hasAuthority("ADMIN")
                    .antMatchers("/json").permitAll()
                    .anyRequest().authenticated()
                    .and()
//               .formLogin()
//                    .and()
               .logout()
               ;              
     }
    
     @Override
     protected void configure(AuthenticationManagerBuilder auth) throws Exception {
          auth.userDetailsService(userService).passwordEncoder(userService.passwordEncoder());
     }
    
     @Bean
     @Override
     public AuthenticationManager authenticationManagerBean() throws Exception {
          return super.authenticationManagerBean();
     }
}

   