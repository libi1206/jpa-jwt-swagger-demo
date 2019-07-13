package com.libi.demo.service;

import com.libi.demo.business.model.BaseResponse;
import com.libi.demo.business.model.vo.UserRegisterVO;

/**
 * @author :Libi
 * @version :1.0
 * @date :2019-07-04 20:33
 */
public interface UserService {
    /**
     * 用户注册的方法
     * @param userRegisterVO
     * @return
     */
    BaseResponse userRegister(UserRegisterVO userRegisterVO);

    /**
     * 用户登陆，获得token
     * @param userName
     * @param password
     * @return
     */
    BaseResponse userLogin(String userName, String password);

    /**
     * 用户获得已登陆的信息
     * @param token
     * @return
     */
    BaseResponse getUserInfo(String token);
}
