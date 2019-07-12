package com.libi.demo;

import com.libi.demo.dao.UserDao;
import com.libi.demo.entity.UserEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = JwtJpaSwaggerDemoApplication.class)
public class JwtJpaSwaggerDemoApplicationTests {
    @Autowired
    private UserDao userDao;

    @Test
    public void contextLoads() {
        UserEntity userEntity = new UserEntity();
        userEntity.setUserId(100L);
        userEntity.setUserName("libi120677");
        userEntity.setPassword("123444");
        userEntity.setCreateTime(System.currentTimeMillis());
        userEntity.setNeckName("团长大人");
        userEntity.setPhone("133333333334");
        userDao.save(userEntity);
    }

    @Test
    /**
     * 官方定义的分页查询，只能进行单表查询
     */
    public void pageTest () {
        //第1页，每页2条数据
        Page<UserEntity> page = userDao.findAll(PageRequest.of(1, 2));
        System.out.println("总条数："+page.getTotalElements());
        System.out.println("总页数："+page.getTotalPages());
        System.out.println("当前页码："+page.getNumber());
        System.out.println("是否有下一页："+page.hasNext());
        List<UserEntity> content = page.getContent();
        //获得数据
        System.out.println(content.size());
        System.out.println(content);
    }

    /**
     * 自己写并且分页
     */
    @Test
    public void pageSelfTest() {
        //第1页，每页2条数据
        Page<UserEntity> page = userDao.findAllByMySelf(PageRequest.of(1, 2),"1");
        System.out.println("总条数："+page.getTotalElements());
        System.out.println("总页数："+page.getTotalPages());
        System.out.println("当前页码："+page.getNumber());
        System.out.println("是否有下一页："+page.hasNext());
        List<UserEntity> content = page.getContent();
        //获得数据
        System.out.println(content.size());
        System.out.println(userDao.findAll());
    }

    @Test
    public void selectTest() {
        System.out.println(userDao.findByUserNameMyself("libi1206"));
    }



}
