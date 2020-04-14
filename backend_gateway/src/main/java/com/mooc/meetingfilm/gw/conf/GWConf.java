package com.mooc.meetingfilm.gw.conf;

import com.mooc.meetingfilm.gw.filters.MyGlobalFilter;
import com.mooc.meetingfilm.gw.predicates.JiangzhAfterRoutePredicateFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author : jiangzh
 * @program : com.mooc.meetingfilm.gw.conf
 * @description : SpringCloud Gateway配置文件
 **/
@Configuration
public class GWConf {

    @Bean
    public JiangzhAfterRoutePredicateFactory initJiangzhAfterRoutePredicateFactory(){
        return new JiangzhAfterRoutePredicateFactory();
    }

    @Bean
    public MyGlobalFilter initMyGlobalFilter(){
        return new MyGlobalFilter();
    }

}
