package com.example.filter;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;

/**
 * @author lilei
 * @since 1.0
 */
@Slf4j
public class RequestTimeGatewayFilterFactory extends AbstractGatewayFilterFactory<RequestTimeGatewayFilterFactory.Config> {

    public static final String REQUEST_TIME_BEGIN = "requestTimeBegin";
    private static final String KEY = "withParams";

    public RequestTimeGatewayFilterFactory() {
        super(Config.class);
    }

    @Override
    public List<String> shortcutFieldOrder() {
        return Arrays.asList(KEY);
    }

    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) -> {
            exchange.getAttributes().put(REQUEST_TIME_BEGIN, System.currentTimeMillis());
            return chain.filter(exchange).then(
                    Mono.fromRunnable(() -> {
                        Long startTime = exchange.getAttribute(REQUEST_TIME_BEGIN);
                        if (startTime != null) {
                            StringBuilder sb = new StringBuilder(exchange.getRequest().getURI().getRawPath())
                                    .append(" : ")
                                    .append(System.currentTimeMillis() - startTime)
                                    .append("ms");
                            if (config.isWithParams()) {
                                sb.append(" params : ").append(exchange.getRequest().getQueryParams());
                            }
                            log.info(sb.toString());
                        }
                    })
            );
        };
    }

    @Data
    public static class Config {
        private boolean withParams;
    }
}