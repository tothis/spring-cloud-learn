package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableHystrix
@EnableTurbine // 包含@EnableDiscoveryClient
@EnableCircuitBreaker
@EnableHystrixDashboard
@EnableEurekaClient
@EnableDiscoveryClient
@SpringBootApplication
public class TurbineServiceApplication {

    // http://localhost:8764/turbine.stream

    public static void main(String[] args) {
        SpringApplication.run(TurbineServiceApplication.class, args);
    }

}