package com.mooc.meetingfilm.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

//可以集成大部分为注册中心
@EnableDiscoveryClient
@SpringBootApplication
public class BackendShowProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackendShowProviderApplication.class, args);
    }

}
