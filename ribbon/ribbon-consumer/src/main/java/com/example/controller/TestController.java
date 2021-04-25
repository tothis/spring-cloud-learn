package com.example.controller;

import com.example.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lilei
 */
@RestController
public class TestController {

    @Autowired
    private TestService testService;

    @GetMapping
    public String test() {
        return testService.test();
    }
}