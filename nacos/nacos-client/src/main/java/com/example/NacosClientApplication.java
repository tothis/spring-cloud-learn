package com.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 当前controller支持热刷新配置中心配置
 */
@RefreshScope
@RestController
@SpringBootApplication
public class NacosClientApplication {

    @Value("${test}")
    private String test;

    public static void main(String[] args) {
        SpringApplication.run(NacosClientApplication.class, args);
    }

    @GetMapping
    public String test() {
        return test;
    }
}