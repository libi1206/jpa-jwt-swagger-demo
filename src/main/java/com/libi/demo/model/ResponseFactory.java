package com.libi.demo.model;

import com.libi.demo.constant.Code;

/**
 * @author :Libi
 * @version :1.0
 * @date :2019-07-04 20:05
 * 响应的工厂类
 */
public class ResponseFactory {
    /**
     * 只用返回码创建响应，使用默认的信息
     * @param code
     * @return
     */
    public static BaseResponse getResponse(Code code) {
        return new BaseResponse<>(code.getCode(), code.getMsg(), null);
    }

    /**
     * 在返回码里加上自己的数据
     * @param code
     * @param data
     * @return
     */
    public static BaseResponse<Object> getResponse(Code code, Object data) {
        return new BaseResponse<>(code.getCode(), code.getMsg(), data);
    }

    /**
     * 自己定义信息和数据
     * @param code
     * @param data
     * @param msg
     * @return
     */
    public static BaseResponse getResponse(Code code, Object data, String msg) {
        return new BaseResponse<>(code.getCode(), msg, data);
    }

    /**
     * 返回调用成功的方法
     * @param data
     * @return
     */
    public static BaseResponse getSussessResponse(Object data) {
        return getResponse(Code.SUSSESS, data);
    }
}
