package com.libi.demo.controller;

import com.libi.demo.business.config.anno.RequestToken;
import com.libi.demo.business.model.BaseResponse;
import com.libi.demo.business.model.vo.UserRegisterVO;
import com.libi.demo.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.constraints.NotNull;

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

    @RequestToken
    @ApiOperation("获取用户信息")
    @RequestMapping(value = "/me", method = RequestMethod.GET)
    public BaseResponse getUserInfo(
            @ApiIgnore @RequestHeader String token
    ) {
        System.out.println(token);
        return userService.getUserInfo(token);
    }

    @ApiOperation("用户获取token")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public BaseResponse login(
            @ApiParam("用户名") @RequestBody  String userName,
            @ApiParam("密码") @RequestBody String password
    ) {
        return userService.userLogin(userName,password);
    }
    

}
