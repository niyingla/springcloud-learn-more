package com.mooc.meetingfilm.apis.film;

import com.mooc.meetingfilm.apis.film.vo.DescribeFilmRespVO;
import com.mooc.meetingfilm.utils.common.vo.BaseResponseVO;
import com.mooc.meetingfilm.utils.exception.CommonServiceException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author : jiangzh
 * @program : com.mooc.meetingfilm.apis.film
 * @description : Film提供的公共接口服务
 **/
public interface FilmFeignApis {

    /**
    * @Description: 对外暴露的接口服务
    * @Param: [filmId]
    * @return: com.mooc.meetingfilm.utils.common.vo.BaseResponseVO
    * @Author: jiangzh
    */
    @RequestMapping(value = "/films/{filmId}", method = RequestMethod.GET)
    BaseResponseVO<DescribeFilmRespVO> describeFilmById(@PathVariable("filmId") String filmId) throws CommonServiceException;

}