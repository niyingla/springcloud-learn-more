package com.mooc.meetingfilm.apigwzuul.filters;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * @author : jiangzh
 * @program : com.mooc.meetingfilm.apigwzuul.filters
 * @description :
 **/
@Slf4j
public class MyFilter extends ZuulFilter {
    /**
    * @Description: Filter类型
    * @Param: []
    * @return: java.lang.String
    * @Author: jiangzh
    */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
    * @Description: filter的执行顺序
    * @Param: []
    * @return: int
    * @Author: jiangzh
    */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
    * @Description: 是否要拦截
    * @Param: []
    * @return: boolean
    * @Author: jiangzh
    */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
    * @Description: Filter的具体业务逻辑
    * @Param: []
    * @return: java.lang.Object
    * @Author: jiangzh
    */
    @Override
    public Object run() throws ZuulException {
        // ThreadLocal
        RequestContext requestContext = RequestContext.getCurrentContext();

        HttpServletRequest request = requestContext.getRequest();

        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()){
            String headName = headerNames.nextElement();
            log.info("headName:{}, headValue:{}", headName, request.getHeader(headName));
        }

        return null;
    }
}
