package com.mooc.meetingfilm.consumer.config;


import com.mooc.meetingfilm.consumer.ribbon.rules.MyRule;
import com.netflix.loadbalancer.*;
import com.netflix.niws.loadbalancer.NIWSDiscoveryPing;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author : jiangzh
 * @program : com.mooc.meetingfilm.consumer.config
 * @description :
 **/
@Configuration
public class RestConfig {

    @Bean
    @LoadBalanced //负载均衡支持
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    /**
    * @Description: 负载均衡规则
     * 使用比较多例如 BestAvailableRule 最快可实现 WeightedResponseTimeRule 响应时间动态平衡
    * @Param: []
    * @return: com.netflix.loadbalancer.IRule
    * @Author: jiangzh
    */
    @Bean
    public IRule iRule(){
        //随机规则
        return new RoundRobinRule();
//        return new MyRule();
    }

    @Bean
    public IPing iPing(){
        //检测服务状态 访问路径 服务 + /abc 失败后从UpServerList删除实例
        // isSecure 是否是安全连接 http 还是 https
        // pingAppendString 具体路径
//        return new PingUrl(false,"/abc");

        //NIWSDiscoveryPing 依赖Eureka 判断
        return new NIWSDiscoveryPing();
    }

}
