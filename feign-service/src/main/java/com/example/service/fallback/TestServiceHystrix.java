package com.example.service.fallback;

import com.example.service.TestService;
import org.springframework.stereotype.Component;

/**
 * @author admin
 * @version V1.0
 * @time 2019/10/24 14:48
 * @description
 */
@Component
public class TestServiceHystrix implements TestService {
    @Override
    public String test() {
        return "error";
    }
}