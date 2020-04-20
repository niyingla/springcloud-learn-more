package com.mooc.meetingfilm.consumer.feign;

import com.mooc.meetingfilm.consumer.feign.vo.UserModel;
import com.mooc.meetingfilm.feignconf.FeignHelloConf;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Primary;
import org.springframework.web.bind.annotation.*;

/**
 * @RequestParam 无论如何都加上
 * FeignClient 会自动生成接口实现 如果要自定义实现 primary =false
 * 然后自己实现类加上@Primary
 */
@Primary //多实现时设置优先级
@FeignClient(
        name = "hello-service-provider", //服务名 value也是取名
        primary = true, //多实现时设置优先级
        path = "/provider", //统一路径
        fallbackFactory = FallbackFactory.class //失败工厂方法
//        fallback = ProviderFallbackAPIImpl.class //失败方法
//        configuration = FeignHelloConf.class,//自定义feign配置
//        url = "http://localhost:7101"  //指定服务路径 默认从ribbon拿
 )
public interface ProviderApi {

    @RequestMapping(value = "/sayhello",method = RequestMethod.GET)
    String invokerProviderController(@RequestParam("message") String message);

//    @RequestLine("GET /sayhello?message={message}")
//    String invokerProviderController(@Param("message") String message);

//    @RequestMapping(value = "/{providerId}/sayhello",method = RequestMethod.POST)
//    String providerPost(
//            @RequestHeader("author") String author,
//            @PathVariable("providerId")String providerId,
//            @RequestBody UserModel userModel);

}
