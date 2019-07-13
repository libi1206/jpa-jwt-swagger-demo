package com.libi.demo.business.config;

import com.libi.demo.business.exception.AuthException;
import com.libi.demo.service.TokenService;
import io.jsonwebtoken.JwtException;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

/**
 * @author :Libi
 * @version :1.0
 * @date :2019-07-12 20:02
 * 这是aop的配置，每一个接口鉴定token的工作都会都会在这里
 */
@Configuration
@Aspect
public class AopConfig {
    Logger logger = LoggerFactory.getLogger(AopConfig.class);

    @Autowired
    private TokenService tokenService;

    /**
     * 这个切面表示必须要在Controller包里并且要有@RequestToken的注解并且要有String token参数才会成为切面
     */
    @Pointcut("within(com.libi.demo.controller.*) " +
            "&& @annotation(com.libi.demo.business.config.anno.RequestToken)" +
            "&& args(..,token)")
    public void verifyAuthPointcut(String token) { }

    /**
     * 这个方法用来处理需要登陆才能完成的请求
     * @param token
     */
    @Before("verifyAuthPointcut(token)")
    public void verifyToken(String token) throws AuthException {
        try {
            tokenService.verifyToken(token);
        } catch (JwtException e) {
            logger.warn(e.getMessage());
            e.printStackTrace();
            throw new AuthException();
        }
    }
}
