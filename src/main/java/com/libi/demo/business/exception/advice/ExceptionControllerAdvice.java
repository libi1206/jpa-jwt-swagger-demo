package com.libi.demo.business.exception.advice;

import com.libi.demo.business.constant.Code;
import com.libi.demo.business.exception.AuthException;
import com.libi.demo.business.model.BaseResponse;
import com.libi.demo.business.model.ResponseFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author :Libi
 * @version :1.0
 * @date :2019-07-13 17:31
 */
@ControllerAdvice
public class ExceptionControllerAdvice {
    @ResponseBody
    @ExceptionHandler(AuthException.class)
    public BaseResponse handleTokenError(AuthException a) {
        return ResponseFactory.getResponse(Code.TOKEN_ERROR);
    }
}
