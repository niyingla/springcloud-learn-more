package com.mooc.meetingfilm.gw.filters;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author : jiangzh
 * @program : com.springcloud.gatewaydemo.Filters
 * @description : 自定义全局Filter
 **/
@Slf4j
public class MyGlobalFilter implements GlobalFilter, Ordered {

  /**
  * @Description: 业务处理逻辑
  * @Param: [exchange, chain]
  * @return: reactor.core.publisher.Mono<java.lang.Void>
  * @Author: jiangzh
  */
  @Override
  public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
    long beginTime = System.currentTimeMillis();
    log.info("filter start ----> beginTime:{}", beginTime);
    return chain.filter(exchange).then(Mono.fromRunnable(()->{
      long endTime = System.currentTimeMillis();
      log.info("filter end ----> endTime: [{}], cost: [{}] ms",endTime , endTime-beginTime);
    }));
  }

  /*
      request -> f1 -> f2 -> f3 -> service
                      ... f2   <-  f3 <-
   */

  /**
  * @Description: 判断Filter顺序的
  * @Param: []
  * @return: int
  * @Author: jiangzh
  */
  @Override
  public int getOrder() {
    return 0;
  }
}
