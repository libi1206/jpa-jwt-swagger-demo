package com.libi.demo.service;

import com.libi.demo.model.BaseResponse;
import com.libi.demo.model.vo.UserRegisterVO;

/**
 * @author :Libi
 * @version :1.0
 * @date :2019-07-04 20:33
 */
public interface UserService {

    BaseResponse userRegister(UserRegisterVO userRegisterVO);

    BaseResponse userLogin(String userName, String password);
}
