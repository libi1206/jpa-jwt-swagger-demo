package com.libi.demo.service.impl;

import com.libi.demo.model.BaseResponse;
import com.libi.demo.model.vo.UserRegisterVO;
import com.libi.demo.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author :Libi
 * @version :1.0
 * @date :2019-07-05 18:06
 */
@Service
public class UserServiceImpl implements UserService {
    @Override
    public BaseResponse userRegister(UserRegisterVO userRegisterVO) {
        return null;
    }

    @Override
    public BaseResponse userLogin(String userName, String password) {
        return null;
    }
}
