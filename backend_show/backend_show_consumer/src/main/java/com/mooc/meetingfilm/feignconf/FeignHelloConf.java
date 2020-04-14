package com.mooc.meetingfilm.feignconf;

import feign.Contract;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author : jiangzh
 * @program : com.mooc.meetingfilm.feignconf
 * @description :
 **/
@Configuration
public class FeignHelloConf {

    @Bean
    public Contract contract(){
        return new feign.Contract.Default();
    }

}
