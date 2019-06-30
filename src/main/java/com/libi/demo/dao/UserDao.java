package com.libi.demo.dao;

import com.libi.demo.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author :Libi
 * @version :1.0
 * @date :2019-06-30 21:07
 */
public interface UserDao extends JpaRepository<UserEntity,Long> {
}
