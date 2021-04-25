package com.example.feign;

import com.example.feign.fallback.ProviderFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author 李磊
 */
@FeignClient(value = "seata-provider", fallbackFactory = ProviderFallback.class)
public interface ProviderFeign {

    @GetMapping
    void get();
}