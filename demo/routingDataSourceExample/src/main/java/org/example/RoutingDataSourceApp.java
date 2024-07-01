package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;

/**
 * Hello world!
 */
@SpringBootApplication
public class RoutingDataSourceApp implements CommandLineRunner {
	
	private static final Logger log = LoggerFactory.getLogger(RoutingDataSourceApp.class);
	@Value("${app.localhost}")
	private String localhost;
	@Value("${spring.application.name}")
	private String name;
	
	public static void main (String[] args) throws IOException {
		ConfigurableApplicationContext aa = SpringApplication.run(RoutingDataSourceApp.class, args);
	}
	
	@Override
	public void run (String... args) throws Exception {
		System.out.println("Hello Spring Boot");
		log.info("localhost:{}", localhost);
		log.info("name:{}", name);
	}
}