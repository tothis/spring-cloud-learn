package com.example.controller;

import com.example.dao.ProviderRepository;
import com.example.entity.Provider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 李磊
 */
@Slf4j
@RestController
public class ProviderController {

    private final ProviderRepository repository;

    public ProviderController(ProviderRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public void get() {
        Provider entity = new Provider();
        entity.setName("提供者");
        repository.save(entity);
    }
}