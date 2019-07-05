package com.libi.demo.constant;

import lombok.Getter;
import lombok.Setter;

/**
 * @author :Libi
 * @version :1.0
 * @date :2019-07-04 20:06
 * 定义返回码
 */
@Getter
public enum Code {
    SUSSESS(0, "成功"),

    PARAM_ERROR(1001, "参数不足或有误"),

    UNKNOWN_ERROR(9001, "未知的异常");


    private int code;
    private String msg;

    Code(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
