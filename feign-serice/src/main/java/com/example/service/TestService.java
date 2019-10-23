package com.example.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author admin
 * @version V1.0
 * @time 2019/10/23 14:39
 * @description
 */
@FeignClient("service")
public interface TestService {

    @GetMapping("test")
    String test();
}