package com.example.service.impl;

import com.example.service.TestService;
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

    @Override
    public String test() {
        return restTemplate.getForObject("http://CLIENT/", String.class);
    }
}