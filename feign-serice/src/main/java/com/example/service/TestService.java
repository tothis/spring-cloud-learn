package com.example.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author admin
 * @version V1.0
 * @time 2019/10/23 14:39
 * @description
 */
@FeignClient("service") // 通过服务名调用指定服务
public interface TestService {

    @GetMapping
    String test();
}