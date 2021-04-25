package com.example.config;

import com.example.filter.RequestTimeFilter;
import com.example.filter.RequestTimeGatewayFilterFactory;
import com.example.filter.TokenFilter;
import com.example.ratelimit.HostAddrKeyResolver;
import com.example.ratelimit.UriKeyResolver;
import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import reactor.core.publisher.Mono;

/**
 * @author 李磊
 */
@Configuration
public class GatewayConfig {
    @Bean
    public TokenFilter tokenFilter() {
        return new TokenFilter();
    }

    @Bean
    public RequestTimeGatewayFilterFactory elapsedGatewayFilterFactory() {
        return new RequestTimeGatewayFilterFactory();
    }

    @Bean
    public HostAddrKeyResolver hostAddrKeyResolver() {
        return new HostAddrKeyResolver();
    }

    @Bean
    public UriKeyResolver uriKeyResolver() {
        return new UriKeyResolver();
    }

    @Primary
    @Bean
    public KeyResolver userKeyResolver() {
        return exchange -> Mono.just(exchange.getRequest().getQueryParams().getFirst("user"));
    }

    @Bean
    public RouteLocator myRoutes(RouteLocatorBuilder builder) {
        String httpUri = "http://httpbin.org:80";
        return builder.routes()
                // .route(p -> p
                //         // 浏览器输入的path
                //         .path("/get")
                //         .filters(f -> f.addRequestHeader("key", "value"))
                //         .uri(httpUri))
                // // 如果请求的域名为runrm.com进入此路由
                // .route(p -> p
                //         .host("*.runrm.com")
                //         .filters(f -> f
                //                 // 失败后的操作
                //                 .hystrix(config -> config
                //                         .setName("this")
                //                         .setFallbackUri("forward:/fallback")))
                //         // 成功的操作
                //         .uri(httpUri)
                // )
                // 自定义filter
                .route(r -> r.path("/time/**")
                        .filters(f -> f.filter(new RequestTimeFilter())
                                .addResponseHeader("X-Response-Default-Li", "Lei"))
                        .uri("http://httpbin.org:80/get")
                        .order(0)
                        .id("filter-router")
                )
                .build();
    }
}