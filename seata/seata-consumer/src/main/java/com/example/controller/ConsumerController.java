package com.example.controller;

import com.example.dao.ConsumerRepository;
import com.example.entity.Consumer;
import com.example.feign.ProviderFeign;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 李磊
 */
@Slf4j
@RestController
public class ConsumerController {

    private final ConsumerRepository consumerRepository;
    private final ProviderFeign providerFeign;

    public ConsumerController(ConsumerRepository consumerRepository, ProviderFeign providerFeign) {
        this.consumerRepository = consumerRepository;
        this.providerFeign = providerFeign;
    }

    @GlobalTransactional
    @GetMapping("{flag}")
    public void get(@PathVariable boolean flag) throws Exception {
        providerFeign.get();
        Consumer entity = new Consumer();
        entity.setName("消费者");
        consumerRepository.save(entity);
        if (flag) {
            throw new Exception("异常");
        }
    }
}