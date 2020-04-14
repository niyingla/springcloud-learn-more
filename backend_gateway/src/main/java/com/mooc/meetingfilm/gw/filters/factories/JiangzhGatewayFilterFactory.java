package com.mooc.meetingfilm.gw.filters.factories;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

/**
 * @author : jiangzh
 * @program : com.springcloud.gatewaydemo.Filters.factorys
 * @description :
 **/
@Slf4j
@Component
public class JiangzhGatewayFilterFactory extends AbstractGatewayFilterFactory<JiangzhGatewayFilterFactory.Config> {

  private static String PARAM_NAME="paramName";
  private static String PARAM_VALUE="paramValue";

  public JiangzhGatewayFilterFactory(){
    super(Config.class);
  }

  @Override
  public GatewayFilter apply(Config config) {
    return ((exchange, chain) -> {
      Set<String> keys = exchange.getRequest().getQueryParams().keySet();
      for(String key : keys){
        log.info("key:{} , value:{}", key, exchange.getRequest().getHeaders().get(key));
      }

      List<String> headNames = exchange.getRequest().getQueryParams().get(config.getParamName());

      if(headNames!=null && headNames.size()>0){
        log.info("PARAM_NAME:{},PARAM_VALUE:{}, headNames:{}",config.getParamName(),config.getParamValue(),headNames);
        if(config.getParamValue().equalsIgnoreCase(headNames.get(0))){
          return chain.filter(exchange);
        }
        exchange.getResponse().setStatusCode(HttpStatus.FORBIDDEN);
      }else{
        exchange.getResponse().setStatusCode(HttpStatus.FORBIDDEN);
      }
      return exchange.getResponse().setComplete();
    });
  }

  @Override
  public List<String> shortcutFieldOrder() {
    return Arrays.asList(PARAM_NAME,PARAM_VALUE);
  }

  @Data
  public static class Config{

    private String paramName;
    private String paramValue;

    public String getParamName() {
      return paramName;
    }

    public void setParamName(String paramName) {
      this.paramName = paramName;
    }

    public String getParamValue() {
      return paramValue;
    }

    public void setParamValue(String paramValue) {
      this.paramValue = paramValue;
    }
  }

}
