package com.mooc.meetingfilm.hall.apis;

import com.mooc.meetingfilm.apis.film.FilmFeignApis;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author : jiangzh
 * @program : com.mooc.meetingfilm.hall.apis
 * @description : film提供的接口服务
 **/
@FeignClient(name = "film-service") //直接继承需要的服务接口 打上注解就引用过来了
public interface FilmFeignApi extends FilmFeignApis {

}
