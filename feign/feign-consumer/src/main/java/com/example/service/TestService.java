package com.example.service;

import com.example.service.fallback.TestServiceHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author lilei
 * @since 1.0
 */
@FeignClient(value = "feign-provider", fallback = TestServiceHystrix.class) // 通过服务名调用指定服务
public interface TestService {

    @GetMapping
    String test();
}