package com.mooc.meetingfilm.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * （以下参数不建议修改）
 * client向server默认30s一次 第一次发起心跳时注册
 * 90s没有收到服务续约（心跳）会剔除服务
 * client退出会发送cancel server端收到后会剔除服务（强制关闭不会发送）
 */
@EnableEurekaServer
@SpringBootApplication
public class BackendEurekaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackendEurekaServerApplication.class, args);
    }

}
