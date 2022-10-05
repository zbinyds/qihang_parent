package com.zbinyds.rabc.service;

import com.zbinyds.rabc.pojo.Role;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author zbinyds
 * @since 2022-10-02
 */
public interface RoleService extends IService<Role> {

    /**
     * 根据用户id查询角色数据
     *
     * @param userId：用户id
     * @return：返回map，包含已分配角色和所有角色信息。
     */
    Map<String, Object> findRoleByUserId(String userId);

    /**
     * 根据用户id给这个用户分配角色
     *
     * @param userId：用户id
     * @param roleId：角色id数组
     */
    void saveUserRoleRealtionShip(String userId, String[] roleId);

    /**
     * 根据用户id获取该用户具备的角色
     *
     * @param id：用户id
     * @return：返回角色列表
     */
    List<Role> selectRoleByUserId(String id);
}
