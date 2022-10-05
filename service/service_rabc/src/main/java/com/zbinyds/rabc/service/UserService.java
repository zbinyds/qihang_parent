package com.zbinyds.rabc.service;

import com.zbinyds.rabc.pojo.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author zbinyds
 * @since 2022-10-02
 */
public interface UserService extends IService<User> {
    // 从数据库中取出用户信息
    User selectByUsername(String username);
}
