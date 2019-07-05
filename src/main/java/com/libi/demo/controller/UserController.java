package com.libi.demo.controller;

import com.libi.demo.model.BaseResponse;
import com.libi.demo.model.vo.UserRegisterVO;
import com.libi.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author :Libi
 * @version :1.0
 * @date :2019-07-04 20:31
 */
@RestController
@RequestMapping("/v1/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/register")
    public BaseResponse register(UserRegisterVO userRegisterVO) {
        return userService.userRegister(userRegisterVO);
    }
    

}
