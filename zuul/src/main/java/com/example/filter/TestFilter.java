package com.example.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @author lilei
 */
@Slf4j
@Component
public class TestFilter extends ZuulFilter {

    @Override
    public String filterType() {
        // pre      调用service之前
        // route    调用service
        // post     调用service之后
        // error    调用出现异常
        return FilterConstants.PRE_TYPE;
    }

    /**
     * 过滤的顺序
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 是否通过过滤
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        log.info(String.format("%s >>> %s", request.getMethod(), request.getRequestURL().toString()));
        log.info("params {}", request.getParameterMap());
        return null;
    }
}