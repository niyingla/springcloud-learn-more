package com.mooc.meetingfilm.user.service;

import com.mooc.meetingfilm.utils.exception.CommonServiceException;

/**
 * @author : jiangzh
 * @program : com.mooc.meetingfilm.user.service
 * @description : 用户接口
 **/
public interface UserServiceAPI {

    String checkUserLogin(String username,String password) throws CommonServiceException;

}
