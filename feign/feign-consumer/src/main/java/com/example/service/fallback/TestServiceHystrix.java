package com.example.service.fallback;

import com.example.service.TestService;
import org.springframework.stereotype.Component;

/**
 * @author lilei
 */
@Component
public class TestServiceHystrix implements TestService {
    public String test() {
        return "error message";
    }
}