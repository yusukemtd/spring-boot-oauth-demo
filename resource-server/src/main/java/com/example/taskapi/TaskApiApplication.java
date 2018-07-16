package com.example.taskapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;


@SpringBootApplication
public class TaskApiApplication {

  public static void main(String[] args) {
    SpringApplication.run(TaskApiApplication.class, args);
  }

  @Configuration
  @EnableResourceServer
  static class ResourceServerConfig extends ResourceServerConfigurerAdapter {
    @Override
    public void configure(HttpSecurity http) throws Exception {
      http.authorizeRequests()
          .antMatchers(HttpMethod.GET, "/v1/**").access("#oauth2.hasScope('read')")
          .antMatchers(HttpMethod.POST, "/v1/**").access("#oauth2.hasScope('write')")
          .antMatchers(HttpMethod.PUT, "/v1/**").access("#oauth2.hasScope('write')")
          .antMatchers(HttpMethod.DELETE, "/v1/**").access("#oauth2.hasScope('write')")
          .antMatchers(HttpMethod.PATCH, "/v1/**").access("#oauth2.hasScope('write')");
    }
  }
}
