package com.mooc.meetingfilm.consumer.ribbon;

import com.netflix.client.ClientException;
import com.netflix.client.ClientFactory;
import com.netflix.client.http.HttpRequest;
import com.netflix.client.http.HttpResponse;
import com.netflix.config.ConfigurationManager;
import com.netflix.loadbalancer.ZoneAwareLoadBalancer;
import com.netflix.niws.client.http.HttpClientRequest;
import com.netflix.niws.client.http.RestClient;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * ribbon是客户端负载均衡器
 * 核心功能
 *  一 服务发现（ServerList） 二 服务选择规则（IRule） 三 服务监听 （IPing）
 *  局部 》全局 》默认   有效范围
 *  默认配置都在 DefaultClientConfigImpl
 *  如果服务地址不是从eureka获取 建议配置IPing
 *
 *
 * @author : jiangzh
 * @program : com.mooc.meetingfilm.consumer.ribbon
 * @description :
 **/
public class App {

    public static void main(String[] args) throws IOException, ClientException, URISyntaxException, InterruptedException {
        // 读取配置文件
        ConfigurationManager.loadPropertiesFromResources("jiangzh.properties");  // 1
        System.err.println(ConfigurationManager.getConfigInstance().getProperty("jiangzh-client.ribbon.listOfServers"));

        //构建一个ribbon HttpClient，serverList固定的情况
        RestClient client = (RestClient) ClientFactory.getNamedClient("jiangzh-client");  // 2
        //创建ribbon请求
        HttpRequest request = HttpRequest.newBuilder().uri(new URI("/")).build(); // 3
        // 1.0
        for (int i = 0; i < 5; i++)  {
            //提交ribbon请求
            HttpResponse response = client.executeWithLoadBalancer(request); // 4
            System.err.println("Status code for " + response.getRequestedURI() + "  :" + response.getStatus());
        }

        // 2.0
        //动态修改的serverList（代码中修改请求地址）
        ZoneAwareLoadBalancer lb = (ZoneAwareLoadBalancer) client.getLoadBalancer();
        System.err.println(lb.getLoadBalancerStats());
        //获取配置实例 设置属性
        ConfigurationManager.getConfigInstance().setProperty(
                "jiangzh-client.ribbon.listOfServers", "www.qq.com:80,www.taobao.com:80"); // 5
        System.err.println("changing servers ...");
        Thread.sleep(3000); // 6
        for (int i = 0; i < 5; i++)  {
            //附带负载均衡去请求
            HttpResponse response = client.executeWithLoadBalancer(request);
            System.err.println("Status code for " + response.getRequestedURI() + "  : " + response.getStatus());
        }
        System.out.println(lb.getLoadBalancerStats()); // 7

        // 最好的情况就是Ribbon和注册中心结合使用

    }

}
