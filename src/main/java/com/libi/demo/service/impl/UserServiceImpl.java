package com.libi.demo.service.impl;

import com.libi.demo.business.constant.Code;
import com.libi.demo.business.model.JwtTokenInfo;
import com.libi.demo.business.model.vo.UserDetailsVO;
import com.libi.demo.dao.UserDao;
import com.libi.demo.entity.UserEntity;
import com.libi.demo.business.model.BaseResponse;
import com.libi.demo.business.model.ResponseFactory;
import com.libi.demo.business.model.vo.UserRegisterVO;
import com.libi.demo.service.TokenService;
import com.libi.demo.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.Optional;
import java.util.UUID;

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
    @Autowired
    private TokenService tokenService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public BaseResponse userRegister(UserRegisterVO userRegisterVO) {
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(userRegisterVO, userEntity);
        userEntity.setCreateTime(System.currentTimeMillis());
        userEntity.setUserId(UUID.randomUUID().toString());
        userDao.save(userEntity);
        entityManager.flush();
        //测试在事物下使用两次save的效果
        UserEntity userEntity1 = new UserEntity();
        userEntity1.setUserId(UUID.randomUUID().toString());
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
        UserEntity userEntity = userDao.findByUserName(userName);
        if (loginSuccess(userEntity, password)) {
            JwtTokenInfo tokenInfo = new JwtTokenInfo();
            tokenInfo.setPhone(userEntity.getPhone());
            tokenInfo.setUserId(userEntity.getUserId());
            tokenInfo.setUserName(userEntity.getUserName());
            return ResponseFactory.getSussessResponse(tokenService.createToken(tokenInfo));
        }
        return ResponseFactory.getResponse(Code.LOGIN_ERROR);

    }

    /**
     * 用于判断是否登陆成功，现在还是简单的判断数据库里的密码和用户输入的是否一致
     * @param userEntity
     * @param password
     * @return
     */
    private boolean loginSuccess(UserEntity userEntity, String password) {
        return userEntity.getPassword().equals(password);
    }

    @Override
    public BaseResponse getUserInfo(String token) {
        JwtTokenInfo tokenInfo = tokenService.verifyToken(token);
        Optional<UserEntity> userEntity = userDao.findById(tokenInfo.getUserId());
        UserDetailsVO userDetailsVO = new UserDetailsVO();
        BeanUtils.copyProperties(userEntity.get(),userDetailsVO);
        return ResponseFactory.getSussessResponse(userDetailsVO);
    }
}
