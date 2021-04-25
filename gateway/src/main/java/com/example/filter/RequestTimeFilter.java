package com.example.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.core.Ordered;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * GatewayFilter
 *
 * @author lilei
 */
@Slf4j
public class RequestTimeFilter implements GatewayFilter, Ordered {

    private static final String REQUEST_TIME_BEGIN = RequestTimeGatewayFilterFactory.REQUEST_TIME_BEGIN;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        exchange.getAttributes().put(REQUEST_TIME_BEGIN, System.currentTimeMillis());
        return chain.filter(exchange).then(
                Mono.fromRunnable(() -> {
                    Long startTime = exchange.getAttribute(REQUEST_TIME_BEGIN);
                    if (startTime != null) {
                        log.info("{} : {}ms", exchange.getRequest().getURI().getRawPath(), (System.currentTimeMillis() - startTime));
                    }
                })
        );
    }

    @Override
    public int getOrder() {
        return 0;
    }
}