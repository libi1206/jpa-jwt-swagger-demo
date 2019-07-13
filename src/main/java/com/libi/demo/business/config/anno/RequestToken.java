package com.libi.demo.business.config.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author :Libi
 * @version :1.0
 * @date :2019-07-12 21:29
 * 打上这个注解的controller接口就会被认为是需要鉴权的接口
 * 打上这个注解的参数别认为是token参数
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface RequestToken {
}
