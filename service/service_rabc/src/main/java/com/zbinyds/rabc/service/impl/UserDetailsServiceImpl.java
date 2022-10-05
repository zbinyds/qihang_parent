package com.zbinyds.rabc.service.impl;

import com.zbinyds.rabc.pojo.User;
import com.zbinyds.rabc.service.PermissionService;
import com.zbinyds.rabc.service.UserService;
import com.zbinyds.security.entity.SecurityUser;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;


/**
 * <p>
 * 自定义userDetailsService - 认证用户详情
 * </p>
 *
 * @author qy
 * @since 2019-11-08
 */
@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Autowired
    private PermissionService permissionService;

    /***
     * 根据账号获取用户信息
     * @param username:前台输入的用户名。
     * @return: org.springframework.security.core.userdetails.UserDetails
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 从数据库中取出用户信息
        User user = userService.selectByUsername(username);

        // 判断用户是否存在
        if (Objects.isNull(user)){
            throw new UsernameNotFoundException("用户名不存在！");
        }
        // 将用户信息赋值给 curUser对象（spring-security中的实体类对象）
        com.zbinyds.security.entity.User curUser = new com.zbinyds.security.entity.User();
        BeanUtils.copyProperties(user,curUser);

        // 查询该用户具备的权限列表并返回
        List<String> authorities = permissionService.selectPermissionValueByUserId(user.getId());
        SecurityUser securityUser = new SecurityUser(curUser);
        securityUser.setPermissionValueList(authorities);
        return securityUser;
    }

}
