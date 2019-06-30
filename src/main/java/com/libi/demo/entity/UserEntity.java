package com.libi.demo.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author :Libi
 * @version :1.0
 * @date :2019-06-30 17:14
 */
@Entity
@Table(name = "jpa_user")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {

    @Id
    @Column(name = "user_id", unique = true, columnDefinition = ("varchar(255) comment '用户的ID'"))
    private Long userId;

    @Column(name = "user_name", unique = true, columnDefinition = ("varchar(255) not null comment '用户名'"))
    private String userName;

    @Column(name = "password",columnDefinition = ("char(60) not null comment '用户的密码'"))
    private String password;

    @Column(name = "neck_name",columnDefinition = ("varchar(255) not null comment '昵称'"))
    private String neckName;

    @Column(name = "phone", unique = true, columnDefinition = ("varchar(50) not null comment '用户的手机号'"))
    private String phone;

    @Column(name = "create_time")
    private Long createTime;
}
