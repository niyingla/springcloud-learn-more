package com.mooc.meetingfilm.feignconf;

import feign.Contract;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 配置类不要放在Application目录下 这类不需要@Configuration 注解。
 * 如果加了这个你还需要在使用@ComponentScan 扫描的时候排除掉，否则就变成全局配置
 * @author : jiangzh
 * @program : com.mooc.meetingfilm.feignconf
 * @description :
 **/
@Configuration//配置需要当前注解
public class FeignHelloConf {

    /**
     * 指定feign的Contract
     * @return
     */
    @Bean //配置需要当前注解
    public Contract contract(){
        return new feign.Contract.Default();
    }

}
