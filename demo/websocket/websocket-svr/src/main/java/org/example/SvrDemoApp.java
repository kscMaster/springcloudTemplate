package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.socket.config.annotation.EnableWebSocket;

/**
 * Hello world!
 *
 */
@EnableWebSocket
@SpringBootApplication
public class SvrDemoApp
{
    public static void main (String[] args) {
        SpringApplication.run(SvrDemoApp.class, args);
    }
}