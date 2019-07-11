package com.libi.demo.service.impl;

import com.libi.demo.dao.UserDao;
import com.libi.demo.entity.UserEntity;
import com.libi.demo.model.BaseResponse;
import com.libi.demo.model.vo.UserRegisterVO;
import com.libi.demo.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author :Libi
 * @version :1.0
 * @date :2019-07-05 18:06
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public BaseResponse userRegister(UserRegisterVO userRegisterVO) {
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(userRegisterVO, userEntity);
        userEntity.setUserId(2L);
        userDao.save(userEntity);
        //测试在事物下使用两次save的效果
        UserEntity userEntity1 = new UserEntity();
        userEntity1.setUserId(1000L);
        userEntity1.setUserName("希望插不进去");
        userEntity1.setPassword("1234444");
        userEntity1.setNeckName("12232");
        userDao.save(userEntity1);
        return null;
    }

    @Override
    public BaseResponse userLogin(String userName, String password) {
        return null;
    }
}
