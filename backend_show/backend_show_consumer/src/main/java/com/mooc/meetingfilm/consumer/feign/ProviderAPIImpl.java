package com.mooc.meetingfilm.consumer.feign;

import com.mooc.meetingfilm.consumer.feign.vo.UserModel;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

//@Primary
@Service
public class ProviderAPIImpl implements ProviderApi{
    @Override
    public String invokerProviderController(String message) {
        return null;
    }

//    @Override
//    public String providerPost(String author, String providerId, UserModel userModel) {
//        return null;
//    }
}
