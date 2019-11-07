package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import reactor.core.publisher.Mono;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = GatewayServiceApplication.class)
public class GatewayServiceApplicationTests {

    @Test
    public void contextLoads() {
        System.out.println(Mono.just("fallback"));
    }

}