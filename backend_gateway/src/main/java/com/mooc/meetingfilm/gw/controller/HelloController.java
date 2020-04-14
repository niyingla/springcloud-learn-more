package com.mooc.meetingfilm.gw.controller;

import com.mooc.meetingfilm.utils.common.vo.BaseResponseVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;

import java.util.Set;

/**
 * @author : jiangzh
 * @program : com.mooc.meetingfilm.gw.controller
 * @description :
 **/
@Slf4j
@RestController
public class HelloController {

    /**
    * @Description:  serverWebExchange - 请求对象，线程安全
     *              throwable - 具体的错误信息
    * @Param: [serverWebExchange, throwable]
    * @return: com.mooc.meetingfilm.utils.common.vo.BaseResponseVO
    * @Author: jiangzh
    */
    @RequestMapping(value = "/myFallback")
    public BaseResponseVO demoFallback(ServerWebExchange serverWebExchange, Throwable throwable){

        Set<String> keys = serverWebExchange.getRequest().getQueryParams().keySet();
        for(String key : keys){
            log.info("key:{} , value:{}", key, serverWebExchange.getRequest().getHeaders().get(key));
        }


        if(throwable !=null){
            log.error("throwable: [{}]", throwable.getMessage());
//            throwable.printStackTrace();
        }

        return BaseResponseVO.success("演示请求失败，降级处理");
    }

}
