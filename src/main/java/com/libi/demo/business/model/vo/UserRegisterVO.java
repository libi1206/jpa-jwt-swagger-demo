package com.libi.demo.business.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @author :Libi
 * @version :1.0
 * @date :2019-07-04 20:27
 */
@Getter
@Setter
@ApiModel //使用这个注解告诉swagger这个类是一个接口所需要的参数
public class UserRegisterVO {
    @ApiModelProperty("用户名") //用这个注解告诉swagger这个参数里面的成员变量
    private String userName;
    @ApiModelProperty("密码")
    private String password;
    @ApiModelProperty("电话")
    private String phone;
    @ApiModelProperty("昵称")
    private String neckName;
}
