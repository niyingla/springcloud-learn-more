package com.mooc.meetingfilm.hall.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author : jiangzh
 * @program : com.mooc.meetingfilm.hall.conf
 * @description :
 **/
@Configuration
public class RestConf {

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

}
