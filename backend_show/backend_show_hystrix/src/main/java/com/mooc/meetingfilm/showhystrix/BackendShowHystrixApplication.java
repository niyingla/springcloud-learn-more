package com.mooc.meetingfilm.showhystrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hystrix 主要作用延迟和容错（熔断）
 * 目标 避免级联故障，提高系统弹性 （c挂了 a请求c一直在等待 a也不行了）
 */
@SpringBootApplication
public class BackendShowHystrixApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackendShowHystrixApplication.class, args);
    }

}
