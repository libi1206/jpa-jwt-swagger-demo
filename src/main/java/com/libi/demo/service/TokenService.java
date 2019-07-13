package com.libi.demo.service;

import com.libi.demo.business.model.JwtTokenInfo;

/**
 * @author :Libi
 * @version :1.0
 * @date :2019-07-12 21:35
 * 用于鉴定Token的服务
 */
public interface TokenService {
    /**
     * 创建一个Token的方法
     * @return
     */
    String createToken(JwtTokenInfo tokenInfo);

    /**
     * 验证有一个Token的信息
     * @param token
     * @return
     */
    JwtTokenInfo verifyToken(String token);
}
