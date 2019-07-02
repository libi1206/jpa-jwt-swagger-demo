package com.libi.demo.dao;

import com.libi.demo.entity.UserEntity;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author :Libi
 * @version :1.0
 * @date :2019-06-30 21:07
 */
public interface UserDao extends JpaRepository<UserEntity,Long> {
    //通过用户名查找用户
    UserEntity findByUserName(String userName);

    //使用本地SQL查询来自定义数据库操作
    @Query(value = "select * from jpa_user where user_name = :user_name", nativeQuery = true)
    UserEntity findByUserNameMyself(@Param("user_name") String userName);

}
