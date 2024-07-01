package org.example;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;

/**
 * Hello world!
 */
@SpringBootApplication
@Slf4j
public class DisCoverSvrApp implements CommandLineRunner {
	
//	@Resource
//	private ExampleUtils exampleUtils;
	
	public static void main (String[] args) throws IOException {
		ConfigurableApplicationContext aa = SpringApplication.run(DisCoverSvrApp.class, args);
	}
	
	@Override
	public void run (String... args) throws Exception {
		System.out.println("Hello Spring Boot");
		log.info("Hello Spring Boot2");
//		System.out.println(exampleUtils.test());
	}
}