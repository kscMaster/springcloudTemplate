package org.example.config;

import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class TestConfig {

//   @Value("${user.names}")
//   public String test1;
//   @Value("${user.pwds}")
//   public String test2;

   @PostConstruct
   public void getUser(){
//       System.out.println("name=" + test1 + "|pwd=" + test2);
   }
}