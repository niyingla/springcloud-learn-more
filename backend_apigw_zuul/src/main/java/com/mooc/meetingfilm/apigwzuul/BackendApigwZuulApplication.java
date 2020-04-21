package com.mooc.meetingfilm.apigwzuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * zuul 线程阻塞 zuul2 异步线程
 */
@EnableZuulProxy
@SpringBootApplication
public class BackendApigwZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackendApigwZuulApplication.class, args);
    }

}
