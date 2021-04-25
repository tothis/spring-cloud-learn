package com.example.feign.fallback;

import com.example.feign.ProviderFeign;
import org.springframework.stereotype.Component;

/**
 * @author 李磊
 */
@Component
public class ProviderFallback implements ProviderFeign {
    public void get() {
        throw new RuntimeException("提供者调用失败");
    }
}