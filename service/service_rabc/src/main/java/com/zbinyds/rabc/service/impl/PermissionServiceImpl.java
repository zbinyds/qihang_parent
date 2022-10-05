package com.zbinyds.rabc.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zbinyds.rabc.helper.MemuHelper;
import com.zbinyds.rabc.pojo.Permission;
import com.zbinyds.rabc.mapper.PermissionMapper;
import com.zbinyds.rabc.pojo.RolePermission;
import com.zbinyds.rabc.pojo.User;
import com.zbinyds.rabc.service.PermissionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zbinyds.rabc.service.RolePermissionService;
import com.zbinyds.rabc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 权限 服务实现类
 * </p>
 *
 * @author zbinyds
 * @since 2022-10-02
 */
@Service
@Transactional // 开启事务
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements PermissionService {
    @Autowired
    private RolePermissionService rolePermissionService;

    @Autowired
    private UserService userService;

    // 查询所有权限
    @Override
    public List<Permission> queryAllMenu() {
        QueryWrapper<Permission> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("id");
        List<Permission> permissionList = baseMapper.selectList(wrapper); // 所有权限菜单
        List<Permission> result = bulid(permissionList); // 使用递归构造树形权限菜单
        return result;
    }

    // 查询角色权限
    @Override
    public List<Permission> selectAllMenu(String roleId) {
        // 查询所有权限
        List<Permission> allPermissionList = baseMapper.selectList(new QueryWrapper<Permission>().orderByAsc("CAST(id AS SIGNED)"));

        // 根据角色id获取角色权限。此时查询结果为List<RolePermission>
        List<RolePermission> rolePermissionList = rolePermissionService.list(new QueryWrapper<RolePermission>().eq("role_id", roleId));
        // 数据再次封装，获取到List<权限id>的集合
        List<String> permissionIdList = rolePermissionList.stream().map(e -> e.getPermissionId()).collect(Collectors.toList());

        // 设置用户所具有的权限（true表示用户具备该权限，false表示用户不具备该权限）
        allPermissionList.forEach(permission -> {
            if(permissionIdList.contains(permission.getId())) {
                permission.setSelect(true);
            } else {
                permission.setSelect(false);
            }
        });
        // 将权限列表以树形结构的形式返回
        List<Permission> permissionList = bulid(allPermissionList);
        return permissionList;
    }

    // 给角色分配权限
    @Override
    public void saveRolePermissionRealtionShip(String roleId, String[] permissionIds) {
        // 先删除该角色所有权限
        rolePermissionService.remove(new QueryWrapper<RolePermission>().eq("role_id", roleId));

        // 待添加权限列表
        List<RolePermission> rolePermissionList = new ArrayList<>();
        for (String permissionId : permissionIds) {
            if (StringUtils.isEmpty(permissionId)) continue;

            RolePermission rolePermission = new RolePermission();
            rolePermission.setRoleId(roleId);
            rolePermission.setPermissionId(permissionId);
            rolePermissionList.add(rolePermission);
        }
        // 批量添加角色权限
        rolePermissionService.saveBatch(rolePermissionList);
    }

    // 递归删除菜单
    @Override
    public void removeChildById(String id) {
        // 1、创建List集合，用于封装要删除的id
        List<String> idList = new ArrayList<>();
        // 2、根据父菜单id，获取到旗下所有子菜单id
        this.selectChildListById(id, idList);
        idList.add(id); // 将父菜单id设置到idList里面
        // 3、进行批量删除
        baseMapper.deleteBatchIds(idList);
    }

    // 根据用户id获取用户菜单
    @Override
    public List<String> selectPermissionValueByUserId(String id) {

        List<String> selectPermissionValueList = null;
        if (this.isSysAdmin(id)) {
            //如果是超级管理员，获取所有权限
            selectPermissionValueList = baseMapper.selectAllPermissionValue();
        } else {
            selectPermissionValueList = baseMapper.selectPermissionValueByUserId(id);
        }
        return selectPermissionValueList;
    }

    @Override
    public List<JSONObject> selectPermissionByUserId(String userId) {
        List<Permission> selectPermissionList = null;
        if (this.isSysAdmin(userId)) {
            //如果是超级管理员，获取所有菜单
            selectPermissionList = baseMapper.selectList(null);
        } else {
            selectPermissionList = baseMapper.selectPermissionByUserId(userId);
        }

        List<Permission> permissionList = bulid(selectPermissionList);
        List<JSONObject> result = MemuHelper.bulid(permissionList);
        return result;
    }

    // ======================================功能方法（非接口）========================================

    /**
     * 判断用户是否为系统管理员
     *
     * @param userId：用户id
     * @return：true or false
     */
    private boolean isSysAdmin(String userId) {
        User user = userService.getById(userId);

        if (null != user && "admin".equals(user.getUsername())) {
            return true;
        }
        return false;
    }

    /**
     * 递归获取子节点
     *
     * @param id：父菜单id
     * @param idList：获取到父菜单id对应的子菜单id集合
     */
    private void selectChildListById(String id, List<String> idList) {
        // 获取到的子菜单集合
        List<Permission> childList = baseMapper.selectList(new QueryWrapper<Permission>().eq("pid", id).select("id"));
        childList.stream().forEach(item -> {
            idList.add(item.getId());
            this.selectChildListById(item.getId(), idList);
        });
    }

    /**
     * 使用递归方法构建树形权限菜单
     *
     * @param treeNodes：所有权限列表
     * @return：返回最终构建好的树形权限菜单。
     */
    private static List<Permission> bulid(List<Permission> treeNodes) {
        // 创建list集合，用于数据最终封装
        List<Permission> trees = new ArrayList<>();
        // 把所有菜单list集合遍历，得到顶层菜单 pid=0菜单，设置level是1
        for (Permission treeNode : treeNodes) {
            if ("0".equals(treeNode.getPid())) {
                treeNode.setLevel(1); // 顶级菜单设置层级为1级
                // 根据顶层菜单，向里面进行查询子菜单，封装到trees里面
                trees.add(findChildren(treeNode, treeNodes));
            }
        }
        return trees;
    }

    /**
     * 根据当前菜单递归查找子菜单
     *
     * @param treeNode：当前菜单
     * @param treeNodes：所有菜单集合
     * @return：将已构建好的当前菜单树形结构返回。
     */
    private static Permission findChildren(Permission treeNode, List<Permission> treeNodes) {
        // 1、因为向一层菜单里面放二层菜单，二层里面还要放三层，因此需要把对象初始化。
        treeNode.setChildren(new ArrayList<Permission>());

        // 2、遍历所有菜单list集合，进行判断比较，比较id和pid值是否相同
        for (Permission it : treeNodes) {
            // id和pid相同，表示找到了子菜单
            if (treeNode.getId().equals(it.getPid())) {
                int level = treeNode.getLevel() + 1; // 子菜单层级设置为父菜单层级+1
                it.setLevel(level);
                if (treeNode.getChildren() == null) {
                    treeNode.setChildren(new ArrayList<Permission>());
                }
                // 继续递归查找下面的子菜单，并将其设置到父菜单里
                treeNode.getChildren().add(findChildren(it, treeNodes));
            }
        }
        // 最终构建好的树形菜单结构
        return treeNode;
    }
}
