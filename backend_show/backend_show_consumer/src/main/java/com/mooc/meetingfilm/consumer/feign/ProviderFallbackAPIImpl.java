package com.mooc.meetingfilm.consumer.feign;

import org.springframework.stereotype.Service;

/**
 * @author : jiangzh
 * @program : com.mooc.meetingfilm.consumer.feign
 * @description : 降级实现
 **/
@Service
public class ProviderFallbackAPIImpl implements ProviderApi{

    @Override
    public String invokerProviderController(String message) {
        return "invokerProviderController fallback message="+message;
    }

}
