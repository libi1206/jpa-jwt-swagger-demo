package com.libi.demo.service.impl;

import com.libi.demo.model.JwtTokenInfo;
import com.libi.demo.service.TokenService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author :Libi
 * @version :1.0
 * @date :2019-07-12 21:43
 */
@Service
public class TokenServiceImpl implements TokenService {
    //默认密钥
    private static final String SECRET = "LIBI_SECRET";
    //过期时间，10分钟，单位：毫秒
    private static final Long EXPIRED_TIME = 10L * 60L * 1000;

    @Override
    public String createToken(JwtTokenInfo tokenInfo) {
        //签名方式
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        //生成负载（这里只能使用Claims来指定，使用PayLoad会报错，说不能和Claims一起使用）
        Map<String, Object> tokenInfoMap = new HashMap<>();
        tokenInfoMap.put("userName", tokenInfo.getUserName());
        tokenInfoMap.put("phone", tokenInfo.getPhone());
        tokenInfoMap.put("userId", tokenInfo.getUserId());
        //生成token的时间
        Long now = System.currentTimeMillis();
        JwtBuilder builder = Jwts.builder()
                //设置Token的Id
                .setId(tokenInfo.getUserId().toString())
                //设置签发时间
                .setIssuedAt(new Date(now))
                //设置过期时间
                .setExpiration(new Date(now + EXPIRED_TIME))
                //设置负载，就是自己定义的数据
                .setClaims(tokenInfoMap)
                //设置签名方式和密钥
                .signWith(signatureAlgorithm, SECRET);
        return builder.compact();
    }

    @Override
    public JwtTokenInfo verifyToken(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(SECRET)
                .parseClaimsJws(token).getBody();
        System.out.println(claims);
        JwtTokenInfo jwtTokenInfo = new JwtTokenInfo();
        jwtTokenInfo.setUserName(claims.get("userName",String.class));
        jwtTokenInfo.setPhone(claims.get("phone",String.class));
        jwtTokenInfo.setUserId(claims.get("userId",Long.class));
        return jwtTokenInfo;
    }

}
