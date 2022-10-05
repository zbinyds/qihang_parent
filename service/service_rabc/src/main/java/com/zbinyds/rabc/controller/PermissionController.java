package com.zbinyds.rabc.controller;

import com.zbinyds.R;
import com.zbinyds.rabc.pojo.Permission;
import com.zbinyds.rabc.service.PermissionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 权限 前端控制器
 * </p>
 *
 * @author zbinyds
 * @since 2022-10-02
 */

@Api(tags = "权限接口管理")
@RestController
@RequestMapping("/admin/rabc/permission")
public class PermissionController {
    @Autowired
    private PermissionService permissionService;

    @ApiOperation(value = "获取所有权限菜单")
    @GetMapping
    public R indexAllPermission() {
        List<Permission> list =  permissionService.queryAllMenu();
        return R.success().data("children",list);
    }

    @ApiOperation(value = "递归删除权限菜单")
    @DeleteMapping("/{id}")
    public R remove(@PathVariable String id) {
        permissionService.removeChildById(id);
        return R.success();
    }

    @ApiOperation(value = "给角色分配权限")
    @PostMapping("/doAssign")
    public R doAssign(String roleId,String[] permissionId) {
        permissionService.saveRolePermissionRealtionShip(roleId,permissionId);
        return R.success();
    }

    @ApiOperation(value = "根据角色获取权限菜单")
    @GetMapping("toAssign/{roleId}")
    public R toAssign(@PathVariable String roleId) {
        List<Permission> list = permissionService.selectAllMenu(roleId);
        return R.success().data("children", list);
    }

    @ApiOperation(value = "新增权限菜单")
    @PostMapping
    public R save(@RequestBody Permission permission) {
        permissionService.save(permission);
        return R.success();
    }

    @ApiOperation(value = "修改权限菜单")
    @PutMapping
    public R updateById(@RequestBody Permission permission) {
        permissionService.updateById(permission);
        return R.success();
    }
}

