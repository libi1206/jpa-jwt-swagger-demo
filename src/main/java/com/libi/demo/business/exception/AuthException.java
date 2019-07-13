package com.libi.demo.business.exception;

/**
 * @author :Libi
 * @version :1.0
 * @date :2019-07-13 16:18
 * 抛出这个异常表示鉴权失败
 */
public class AuthException extends Exception {
    public AuthException() {
        super("鉴权失败！请重新申请Token");
    }
}
