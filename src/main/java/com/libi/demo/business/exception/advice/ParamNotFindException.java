package com.libi.demo.business.exception.advice;

import java.util.List;

/**
 * @author :Libi
 * @version :1.0
 * @date :2019-07-13 19:56
 */
public class ParamNotFindException extends Exception {
    public ParamNotFindException(List<String> paramList) {
        super("以下的参数没有找到"+paramList);
    }
}
