package com.mooc.meetingfilm.consumer.feign;

import org.springframework.stereotype.Service;

/**
 * @author : jiangzh
 * @program : com.mooc.meetingfilm.consumer.feign
 * @description :
 **/
@Service
public class FallbackFactory implements feign.hystrix.FallbackFactory {

    /**
     * 实现接口方法
     * @param throwable
     * @return
     */
    @Override
    public ProviderApi create(Throwable throwable) {
        return message -> "invokerProviderController FallbackFactory message="+message;
    }

}
