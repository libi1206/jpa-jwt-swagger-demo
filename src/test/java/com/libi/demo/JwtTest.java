package com.libi.demo;

import com.libi.demo.model.JwtTokenInfo;
import com.libi.demo.service.TokenService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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
        jwtTokenInfo.setUserId(1L);
        jwtTokenInfo.setPhone("13333333333");
        jwtTokenInfo.setUserName("libi1206");
        String token = tokenService.createToken(jwtTokenInfo);
        JwtTokenInfo jwtTokenInfo1 = tokenService.verifyToken(token);
        System.out.println(jwtTokenInfo1);
    }
}
