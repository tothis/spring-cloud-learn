package com.example.service.impl;

import com.example.service.TestService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author admin
 * @version V1.0
 * @time 2019/10/23 14:40
 * @description
 */
@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "error")
    @Override
    public String test() {
        return restTemplate.getForObject("http://SERVICE/", String.class);
    }

    private String error() {
        return "error";
    }
}