package org.example;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;

/**
 * Hello world!
 *
 */

@SpringBootApplication
@Slf4j
public class App
{
    public static void main (String[] args) throws IOException {
        ConfigurableApplicationContext aa = SpringApplication.run(App.class, args);
        log.info("111");
    }
}