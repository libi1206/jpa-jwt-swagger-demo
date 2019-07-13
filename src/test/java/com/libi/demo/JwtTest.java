package com.libi.demo;

import com.libi.demo.business.model.JwtTokenInfo;
import com.libi.demo.service.TokenService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

/**
 * @author :Libi
 * @version :1.0
 * @date :2019-07-13 14:01
 * 测试jwt的运行情况
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = JwtJpaSwaggerDemoApplication.class)
public class JwtTest {
    @Autowired
    TokenService tokenService;

    @Test
    public void testToken() {
        JwtTokenInfo jwtTokenInfo = new JwtTokenInfo();
        jwtTokenInfo.setUserId(UUID.randomUUID().toString());
        jwtTokenInfo.setPhone("13333333333");
        jwtTokenInfo.setUserName("libi1206");
        String token = tokenService.createToken(jwtTokenInfo);
        System.out.println(token);
        JwtTokenInfo jwtTokenInfo1 = tokenService.verifyToken("eyJhbGciOiJIUzI1NiJ9.eyJwaG9uZSI6IjEzMzMzMzMzMzMzIiwidXNlck5hbWUiOiJsaWJpMTIwNiIsInVzZXJJZCI6MX0.rn50sfwgIr1DIYKUbHcR7z7uRmbNMk0_WQmr8e158Pg");
        System.out.println(jwtTokenInfo1);
    }
}
