package com.example.service.fallback;

import com.example.service.TestService;
import org.springframework.stereotype.Component;

/**
 * @author lilei
 * @since 1.0
 */
@Component
public class TestServiceHystrix implements TestService {
    @Override
    public String test() {
        return "error message";
    }
}