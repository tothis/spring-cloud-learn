package com.example.service.impl;

import com.example.service.TestService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author lilei
 * @version 1.0
 * @time 2019/10/23 14:40
 * @description
 */
@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "error")
    @Override
    // @TxTransaction(isStart = true)
    // @Transactional
    public String test() {
        // ribbon会根据服务名来选择具体服务 在请求时会用具体url替换掉服务名
        return restTemplate.getForObject("http://SERVICE/", String.class);
    }

    private String error() {
        return "error";
    }
}