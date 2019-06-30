package com.libi.demo;

import com.libi.demo.dao.UserDao;
import com.libi.demo.entity.UserEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = JwtJpaSwaggerDemoApplication.class)
public class JwtJpaSwaggerDemoApplicationTests {
    @Autowired
    private UserDao userDao;

    @Test
    public void contextLoads() {
        UserEntity userEntity = new UserEntity();
        userEntity.setUserId(1L);
        userEntity.setUserName("libi1206");
        userEntity.setPassword("3306");
        userEntity.setCreateTime(System.currentTimeMillis());
        userEntity.setNeckName("团长大人");
        userEntity.setPhone("133333333333");
        userDao.save(userEntity);
    }

}
