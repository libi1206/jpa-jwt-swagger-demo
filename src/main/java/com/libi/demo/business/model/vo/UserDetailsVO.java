package com.libi.demo.business.model.vo;

import lombok.Data;

import javax.persistence.Column;

/**
 * @author :Libi
 * @version :1.0
 * @date :2019-07-13 16:42
 */
@Data
public class UserDetailsVO {
    private String userId;
    private String userName;
    private String password;
    private String neckName;
    private String phone;
    private Long createTime;
    private String ext;
}
