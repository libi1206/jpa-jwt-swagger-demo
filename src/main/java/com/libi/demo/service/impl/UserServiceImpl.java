package com.libi.demo.service.impl;

import com.libi.demo.dao.UserDao;
import com.libi.demo.entity.UserEntity;
import com.libi.demo.model.BaseResponse;
import com.libi.demo.model.ResponseFactory;
import com.libi.demo.model.vo.UserRegisterVO;
import com.libi.demo.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

/**
 * @author :Libi
 * @version :1.0
 * @date :2019-07-05 18:06
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private EntityManager entityManager;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public BaseResponse userRegister(UserRegisterVO userRegisterVO) {
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(userRegisterVO, userEntity);
        userEntity.setUserId(3L);
        userDao.save(userEntity);
        entityManager.flush();
        //测试在事物下使用两次save的效果
        UserEntity userEntity1 = new UserEntity();
        userEntity1.setUserId(1003450L);
        userEntity1.setUserName("希望插不进去2");
        userEntity1.setPassword("12344324544");
        userEntity1.setNeckName("122323453252");
        userEntity1.setPhone("123123123124");
        userDao.save(userEntity1);
        entityManager.clear();
        return ResponseFactory.getSussessResponse("插入成功");
    }

    @Override
    public BaseResponse userLogin(String userName, String password) {
        return null;
    }
}
