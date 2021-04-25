package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author 李磊
 */
@EnableFeignClients
@SpringBootApplication
public class SeataConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(SeataConsumerApplication.class, args);
    }
}