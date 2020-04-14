package com.mooc.meetingfilm.consumer.controller;

import com.mooc.meetingfilm.consumer.feign.ProviderApi;
import com.mooc.meetingfilm.consumer.feign.vo.UserModel;
import com.mooc.meetingfilm.consumer.service.ConsumerServiceAPI;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author : jiangzh
 * @program : com.mooc.meetingfilm.consumer.controller
 * @description :
 **/
@Slf4j
@RestController
public class ConsumerController {

    @Autowired
    private ConsumerServiceAPI serviceAPI;

    @Resource
    private ProviderApi providerApi;

    @RequestMapping(value = "/sayhello/feign")
    public String sayHelloFeign(String message){
        System.out.println("feign message="+message);
        return providerApi.invokerProviderController(message);
    }

//    @RequestMapping(value = "/sayhello/post")
//    public String sayHelloPost(String author, String providerId, UserModel userModel){
//        log.info("author:{}, providerId:{}, userModel:{}",author,providerId,userModel);
//        return providerApi.providerPost(author,providerId,userModel);
//    }

    @RequestMapping(value = "/sayhello")
    public String sayHello(String message){

        return serviceAPI.sayHello(message);
    }

}
