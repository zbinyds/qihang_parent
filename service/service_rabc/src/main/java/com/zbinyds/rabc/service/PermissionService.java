package com.zbinyds.rabc.service;

import com.alibaba.fastjson.JSONObject;
import com.zbinyds.rabc.pojo.Permission;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 权限 服务类
 * </p>
 *
 * @author zbinyds
 * @since 2022-10-02
 */
public interface PermissionService extends IService<Permission> {

    /**
     * 获取所有权限菜单（树形结构）
     *
     * @return
     */
    List<Permission> queryAllMenu();

    /**
     * 删除权限菜单（如果该菜单下，包含子菜单也一并删除）
     *
     * @param id：权限id
     */
    void removeChildById(String id);

    /**
     * 获取某角色的权限菜单
     *
     * @param roleId：角色id
     * @return
     */
    List<Permission> selectAllMenu(String roleId);

    /**
     * 给角色分配权限菜单
     *
     * @param roleId：角色id
     * @param permissionId：权限id列表（批量添加）
     */
    void saveRolePermissionRealtionShip(String roleId, String[] permissionId);

    /**
     * 获取某用户的所有权限值
     *
     * @param id：管理用户id
     * @return：返回该用户的所有权限值
     */
    List<String> selectPermissionValueByUserId(String id);

    /**
     * 获取某用户的所有权限菜单（用于登录后左侧菜单列表展示）
     *
     * @param id：管理用户id
     * @return：返回以树形结构构造好的Json对象。
     */
    List<JSONObject> selectPermissionByUserId(String id);
}
