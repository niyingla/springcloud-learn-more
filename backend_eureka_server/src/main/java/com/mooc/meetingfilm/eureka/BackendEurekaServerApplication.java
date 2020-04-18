package com.mooc.meetingfilm.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * （以下参数不建议修改）
 * client向server默认30s一次 第一次发起心跳时注册
 * 90s没有收到服务续约（心跳）会剔除服务
 * client退出会发送cancel server端收到后会剔除服务（强制关闭不会发送）
 * client缓存注册信息 默认30s去server取一次
 *
 * C 一致性 A 可用性 P 分区容错性 不可以同时满足
 * eureka A P zookeeper C P
 *
 * client延迟注册 30s
 * server响应缓存 30s
 * server刷新缓存 30s （三项累计 最多90s）
 *
 *
 * eureka自我保护 续约频率低于阈值 进入保护模式
 * 保护模式下 不会提出注册信息 （可以发送请求剔除）
 */
@EnableEurekaServer
@SpringBootApplication
public class BackendEurekaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackendEurekaServerApplication.class, args);
    }

}
