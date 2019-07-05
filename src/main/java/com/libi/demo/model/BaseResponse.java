package com.libi.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author :Libi
 * @version :1.0
 * @date :2019-07-04 19:54
 * 基础的返回数据结构
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BaseResponse<T> {
    private int code;
    private String msg;
    private T data;
}
