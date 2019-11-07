package com.example;

import brave.sampler.Sampler;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Slf4j
@RestController
@EnableHystrix
@EnableCircuitBreaker
@EnableHystrixDashboard
@EnableEurekaClient
@EnableDiscoveryClient
@SpringBootApplication
public class ServiceApplication {

    // 访问http://localhost:8762/actuator/hystrix.stream

    public static void main(String[] args) {
        SpringApplication.run(ServiceApplication.class, args);
    }

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    @Autowired
    private RestTemplate restTemplate;

    @Value("${server.port}")
    private int port;

    @HystrixCommand(fallbackMethod = "error")
    @GetMapping("test")
    public String test() {
        return "port : " + port;
    }

    private String error() {
        return "error error error";
    }

    @GetMapping("test1")
    public String test1() {
        log.info("calling trace service");
        return restTemplate.getForObject("http://localhost:8989/test", String.class);
    }

    @GetMapping("test2")
    public String test2() {
        log.info("calling trace service");
        return "test-test-test";
    }

    @Bean
    public Sampler defaultSampler() {
        return Sampler.ALWAYS_SAMPLE;
    }
}