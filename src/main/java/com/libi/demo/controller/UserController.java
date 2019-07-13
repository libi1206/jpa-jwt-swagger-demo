package com.libi.demo.controller;

import com.libi.demo.model.BaseResponse;
import com.libi.demo.model.vo.UserRegisterVO;
import com.libi.demo.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author :Libi
 * @version :1.0
 * @date :2019-07-04 20:31
 */
@RestController
@RequestMapping("/v1/user")
@Api //使用API注解告诉Swagger这个是一个API
public class UserController {
    @Autowired
    private UserService userService;

    @ApiOperation("用户注册") //使用这个注解告诉Swagger这个方法是一个需要关注的接口
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public BaseResponse register(
            @ApiParam @RequestBody UserRegisterVO userRegisterVO //使用这个注解告诉swagger这个是接口的参数需要注意
    ) {
        return userService.userRegister(userRegisterVO);
    }
    

}
