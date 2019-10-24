package com.example.service;

import com.example.service.fallback.TestServiceHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author admin
 * @version V1.0
 * @time 2019/10/23 14:39
 * @description
 */
@FeignClient(value = "service", fallback = TestServiceHystrix.class) // 通过服务名调用指定服务
public interface TestService {

    @GetMapping
    String test();
}