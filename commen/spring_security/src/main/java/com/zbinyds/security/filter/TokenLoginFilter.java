package com.zbinyds.security.filter;

import com.zbinyds.R;
import com.zbinyds.ResponseUtil;
import com.zbinyds.security.entity.SecurityUser;
import com.zbinyds.security.entity.User;
import com.zbinyds.security.security.TokenManager;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * <p>
 * 认证过滤器，继承UsernamePasswordAuthenticationFilter，对用户名密码进行登录校验
 * </p>
 *
 * @author qy
 * @since 2019-11-08
 */
public class TokenLoginFilter extends UsernamePasswordAuthenticationFilter {

    private AuthenticationManager authenticationManager;
    private TokenManager tokenManager;
    private RedisTemplate redisTemplate;

    /**
     * 构造器初始化
     *
     * @param authenticationManager：认证管理器（通过authenticate()方法判断用户认证结果）
     * @param tokenManager：jwt工具类（用户生成token）
     * @param redisTemplate：redis工具类（用于存放用户权限信息）
     */
    public TokenLoginFilter(AuthenticationManager authenticationManager, TokenManager tokenManager, RedisTemplate redisTemplate) {
        this.authenticationManager = authenticationManager;
        this.tokenManager = tokenManager;
        this.redisTemplate = redisTemplate;
        this.setPostOnly(false);
        // 设置登录接口为/admin/rabc/login
        this.setRequiresAuthenticationRequestMatcher(new AntPathRequestMatcher("/admin/rabc/login", "POST"));
    }

    /**
     * 进行用户认证，返回authentication对象。
     * （如果认证成功，authentication对象包含了用户信息。否则，authentication对象为null）
     *
     * @param req
     * @param res
     * @return
     * @throws AuthenticationException
     */
    @Override
    public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse res)
            throws AuthenticationException {
        try {
            // 获取到表单提交过来的用户信息
            User user = new ObjectMapper().readValue(req.getInputStream(), User.class);
            return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword(), new ArrayList<>()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * 登录成功
     *
     * @param req
     * @param res
     * @param chain
     * @param auth
     * @throws IOException
     * @throws ServletException
     */
    @Override
    protected void successfulAuthentication(HttpServletRequest req, HttpServletResponse res, FilterChain chain,
                                            Authentication auth) throws IOException, ServletException {
        // 获取到认证成功的用户信息
        SecurityUser user = (SecurityUser) auth.getPrincipal();
        // 使用Jwt工具类为当前用户生成token
        String token = tokenManager.createToken(user.getCurrentUserInfo().getUsername());
        // 将用户权限写入redis中。key为用户名，value为权限列表。
        redisTemplate.opsForValue().set("user::" + user.getCurrentUserInfo().getUsername(), user.getPermissionValueList());
        // 返回提示信息
        ResponseUtil.out(res, R.success().message("登陆成功！").data("token", token));
    }

    /**
     * 登录失败
     *
     * @param request
     * @param response
     * @param e
     * @throws IOException
     * @throws ServletException
     */
    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response,
                                              AuthenticationException e) throws IOException, ServletException {
        ResponseUtil.out(response, R.failed().message("用户名或密码错误！"));
    }
}
