package com.mooc.meetingfilm.testng;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * docker 操作必须是root或者同等级权限
 * docker 创建docker文件
 * docker build -t 火华一号:1.0 .
 *  创建名字为火华一号 版本为1.0的docker文件
 *  docker run -itd -p 8080:8761 火华一号:1.0
 *  //后台运行这个镜像 镜像8761端口映射到本机8080
 */
@SpringBootApplication
public class BackendShowTestngApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackendShowTestngApplication.class, args);
    }

}
