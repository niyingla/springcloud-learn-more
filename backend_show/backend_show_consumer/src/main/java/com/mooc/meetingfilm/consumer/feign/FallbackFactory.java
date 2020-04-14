package com.mooc.meetingfilm.consumer.feign;

import org.springframework.stereotype.Service;

/**
 * @author : jiangzh
 * @program : com.mooc.meetingfilm.consumer.feign
 * @description :
 **/
@Service
public class FallbackFactory implements feign.hystrix.FallbackFactory {

    @Override
    public ProviderApi create(Throwable throwable) {
        return new ProviderApi() {
            @Override
            public String invokerProviderController(String message) {
                return "invokerProviderController FallbackFactory message="+message;
            }
        };
    }

}
