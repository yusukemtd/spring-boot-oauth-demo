package com.example.taskauthz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.provider.ClientDetailsService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

  @Autowired
  private ClientDetailsService clientDetailsService;

  @Override
  protected void configure(HttpSecurity http) throws Exception {

    http.requestMatchers().antMatchers("/", "/login", "/oauth/authorize", "/oauth/confirm_access")
        .and()
          .authorizeRequests().anyRequest().authenticated()
        .and()
          .formLogin().loginPage("/login").permitAll();
  }

  @Override
  protected void configure(AuthenticationManagerBuilder authentication) throws Exception {
    // Inmemory End-User
    authentication.inMemoryAuthentication()
      .withUser("user")
      .password(passwordEncoder().encode("password"))
      .roles("USER");
  }

  @Bean
  public BCryptPasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Bean
  @Override
  public AuthenticationManager authenticationManagerBean() throws Exception {
    return super.authenticationManagerBean();
  }
}
