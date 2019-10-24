package com.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class ConfigClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigClientApplication.class, args);
    }

    // a.properties a.yml 相同的键显示properties的值
    @Value("${test-version}")
    private String test;

    @Value("${username}")
    private String username;

    @ResponseBody
    @GetMapping
    public String test() {
        return test + "\n" + username;
    }
}