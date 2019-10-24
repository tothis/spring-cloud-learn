package com.example.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author admin
 * @version V1.0
 * @time 2019/10/24 15:48
 * @description
 */
@Slf4j
public class TestFilter extends ZuulFilter {

    @Override
    public String filterType() {
        // pre      路由之前
        // routing  路由之时
        // post     路由之后
        // error    发送错误调用
        return "pre";
    }

    // 过滤的顺序
    @Override
    public int filterOrder() {
        return 0;
    }

    // 是否通过过滤
    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        log.info(String.format("%s >>> %s", request.getMethod(), request.getRequestURL().toString()));
        Object accessToken = request.getParameter("token");
        if (accessToken == null) {
            log.warn("token is empty");
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            try {
                ctx.getResponse().getWriter().write("token is empty");
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
        log.info("ok");
        return null;
    }
}