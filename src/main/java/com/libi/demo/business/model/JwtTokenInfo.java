package com.libi.demo.business.model;

import lombok.Data;
import lombok.ToString;

/**
 * @author :Libi
 * @version :1.0
 * @date :2019-07-12 21:21
 * 这是jwt鉴权所包含的数据
 */
@Data
@ToString
public class JwtTokenInfo {
    private String userId;
    private String userName;
    private String phone;
}
