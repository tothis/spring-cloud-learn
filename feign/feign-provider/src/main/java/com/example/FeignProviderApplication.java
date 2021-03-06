package com.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 李磊
 */
@RestController
@SpringBootApplication
public class FeignProviderApplication {

    @Value("${server.port}")
    private int port;

    public static void main(String[] args) {
        SpringApplication.run(FeignProviderApplication.class, args);
    }

    @GetMapping
    public String test() {
        return "feign-provider " + port;
    }
}