package com.example.Ecommerce.Application.Configuration;


import com.example.Ecommerce.Application.CustomuserDetail.CustomerUserDetailService;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig{

      @Bean
      public UserDetailsService userDetailsService(){
      return new CustomerUserDetailService();
     }

     @Bean
     public BCryptPasswordEncoder bCryptPasswordEncoder(){
      return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        return http.authorizeHttpRequests()
          .requestMatchers("/admin/**").hasRole("ADMIN")
          .requestMatchers("/user/**").hasRole("USER")
          .requestMatchers("/**","/registerpage","/register","/showproduct","/addcart/{id}").permitAll()
          .and()
          .formLogin()
          .loginPage("/dologin")
          .loginProcessingUrl("/dologin")
          .defaultSuccessUrl("/user/dashboard")
          .failureUrl("/login-fail")
          //.permitAll()
          .and().csrf().disable().build();
         

      }

     @Bean
     public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider daoAuthenticationProvider=new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(userDetailsService());
        daoAuthenticationProvider.setPasswordEncoder(bCryptPasswordEncoder());
        return daoAuthenticationProvider;
     }
      

}
