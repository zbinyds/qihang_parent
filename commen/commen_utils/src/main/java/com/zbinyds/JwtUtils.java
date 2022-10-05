package com.zbinyds;

import io.jsonwebtoken.*;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @author zbinyds
 * @time 2022/09/25 19:34
 * <p>
 * JWT工具类。用于生成JWT、校验JWT等。
 */
public class JwtUtils {
    public static final long EXPIRE = 1000 * 60 * 60 * 24; // JWT有效期
    public static final String APP_SECRET = "zbinyds"; // JWT秘钥

    /**
     * 生成JWT令牌（有效期24h）
     *
     * @param id：用户id
     * @param nickname：用户名
     * @return：返回生成的JWT令牌
     */
    public static String getJwtToken(String id, String nickname) {
        String JwtToken = Jwts.builder()
                // 设置头信息
                .setHeaderParam("typ", "JWT")
                .setHeaderParam("alg", "HS256")
                // 设置主体信息（自定义参数，主题、签发时间、用户相关信息等）
                // 设置主题
                .setSubject("qihang-user")
                // 签发时间
                .setIssuedAt(new Date())
                // 过期时间
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE))
                // 自定义参数
                .claim("id", id)
                .claim("nickname", nickname)
                // 签发人及加密算法选择（默认为hs256算法）
                .signWith(SignatureAlgorithm.HS256, APP_SECRET)
                // 生成JWT令牌
                .compact();
        return JwtToken;
    }

    /**
     * 判断token是否存在与有效
     *
     * @param jwtToken：JWT令牌
     * @return：true or false
     */
    public static boolean checkToken(String jwtToken) {
        if (StringUtils.isEmpty(jwtToken)) return false;
        try {
            Jwts.parser().setSigningKey(APP_SECRET).parseClaimsJws(jwtToken);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * 判断token是否存在与有效
     *
     * @param request：当前请求
     * @return：true or false
     */
    public static boolean checkToken(HttpServletRequest request) {
        try {
            String jwtToken = request.getHeader("token");
            if (StringUtils.isEmpty(jwtToken)) return false;
            Jwts.parser().setSigningKey(APP_SECRET).parseClaimsJws(jwtToken);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * 根据token获取用户id
     *
     * @param request：当前请求
     * @return：返回获取到的用户id
     */
    public static String getMemberIdByJwtToken(HttpServletRequest request) {
        String jwtToken = request.getHeader("token");
        if (StringUtils.isEmpty(jwtToken)) return "";

        Jws<Claims> claimsJws = null;
        try {
            claimsJws = Jwts.parser().setSigningKey(APP_SECRET).parseClaimsJws(jwtToken);
        } catch (Exception e) {
            return "";
        }
        Claims claims = claimsJws.getBody();
        return (String) claims.get("id");
    }
}
