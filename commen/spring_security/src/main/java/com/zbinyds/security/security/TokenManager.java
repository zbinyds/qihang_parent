package com.zbinyds.security.security;

import io.jsonwebtoken.CompressionCodecs;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * <p>
 * jwt工具类。用户生成token、根据token取值
 * </p>
 *
 * @author qy
 * @since 2019-11-08
 */
@Component
public class TokenManager {

    private long tokenExpiration = 24 * 60 * 60 * 1000; // token过期时间（24h有效）
    private String tokenSignKey = "zbinyds"; // jwt秘钥

    /**
     * 根据username生成token
     *
     * @param username：认证成功的用户名
     * @return：token
     */
    public String createToken(String username) {
        String token = Jwts.builder().setSubject(username)
                .setExpiration(new Date(System.currentTimeMillis() + tokenExpiration))
                .signWith(SignatureAlgorithm.HS512, tokenSignKey).compressWith(CompressionCodecs.GZIP).compact();
        return token;
    }

    /**
     * 解析token。根据token获取用户名。
     *
     * @param token
     * @return
     */
    public String getUserFromToken(String token) {
        String user = Jwts.parser().setSigningKey(tokenSignKey).parseClaimsJws(token).getBody().getSubject();
        return user;
    }

    /**
     *  TODO：将token设置为过期状态。
     * @param token
     */
    public void removeToken(String token) {
        //jwttoken无需删除，客户端扔掉即可。
    }

}
