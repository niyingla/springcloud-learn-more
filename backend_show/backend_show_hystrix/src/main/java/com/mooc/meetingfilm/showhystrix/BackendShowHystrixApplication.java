package com.mooc.meetingfilm.showhystrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hystrix 主要作用延迟和容错（熔断）
 * 目标 避免级联故障，提高系统弹性 （c挂了 a请求c一直在等待 a也不行了）
 *
 * 1 开始执行Hystrix （同步执行|异步执行两种）
 * 3 判断缓存是否可用（是否开启缓存，有数据）
 * 4 是否开启熔断 否 快速失败
 * 5 信号量是否到达上限 是 快速失败
 * 6 执行业务逻辑 超时 快速失败
 *
 */
@SpringBootApplication
public class BackendShowHystrixApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackendShowHystrixApplication.class, args);
    }

}
