package com.akakour.lab.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * 前置过滤器
 */
@Slf4j
@Component
public class PreHeadFilter extends ZuulFilter {
    /**
     * 过滤器类型
     * pre: 这种过滤器在请求被路由之前调用。可利用这种过滤器实现身份验证、在集群中选择请求的微服务，记录调试信息等。
     * routing: 这种过滤器将请求路由到微服务。这种过滤器用于构建发送给微服务的请求，并使用apache httpclient或netflix ribbon请求微服务。
     * post: 这种过滤器在路由到微服务以后执行。这种过滤器可用来为响应添加标准的http header、收集统计信息和指标、将响应从微服务发送给客户端等。
     * error: 在其他阶段发送错误时执行该过滤器。
     *
     * @return
     */
    @Override
    public String filterType() {
        //前过滤器
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        //同级过滤器优先级，数字越小越优先
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return RequestContext.getCurrentContext().sendZuulResponse();
//        return false;
    }

    @Override
    public Object run() throws ZuulException {
        log.info("PreHeadFilter:run()------------------------------");
        RequestContext currentContext = RequestContext.getCurrentContext();
        //设置为false不进行路由
//        currentContext.setSendZuulResponse(false);  //进行拦截，阻止火炬传递
//        currentContext.setResponseStatusCode(401);
        HttpServletRequest request = currentContext.getRequest();
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headername = headerNames.nextElement();
            log.info("header from request : " + headername + " --------------> " + request.getHeader(headername));
        }
        return null;
    }
}
