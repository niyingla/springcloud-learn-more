package com.mooc.meetingfilm.feignconf;

import feign.Contract;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 配置类不要放在Application目录下
 * @author : jiangzh
 * @program : com.mooc.meetingfilm.feignconf
 * @description :
 **/
@Configuration
public class FeignHelloConf {

    /**
     * 指定feign的Contract
     * @return
     */
    @Bean
    public Contract contract(){
        return new feign.Contract.Default();
    }

}
