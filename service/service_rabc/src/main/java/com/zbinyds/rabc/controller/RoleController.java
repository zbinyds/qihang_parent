package com.zbinyds.rabc.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.zbinyds.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zbinyds.rabc.pojo.Role;
import com.zbinyds.rabc.service.RoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author zbinyds
 * @since 2022-10-02
 */

@Api(tags = "角色接口管理")
@RestController
@RequestMapping("/admin/rabc/role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @ApiOperation(value = "获取角色分页列表")
    @GetMapping("/page/{page}/{limit}")
    public R index(
            @ApiParam(name = "page", value = "当前页码", required = true)
            @PathVariable Long page,

            @ApiParam(name = "limit", value = "每页记录数", required = true)
            @PathVariable Long limit,
            Role role) {
        Page<Role> rolePage = new Page<>(page, limit);
        // 构造分页查询条件
        LambdaQueryWrapper<Role> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(!StringUtils.isEmpty(role.getRoleName()), Role::getRoleName, role.getRoleName());
        // 进行查询
        roleService.page(rolePage, queryWrapper);
        return R.success().data("items", rolePage.getRecords()).data("total", rolePage.getTotal());
    }

    @ApiOperation(value = "根据角色id获取角色信息")
    @GetMapping("/{id}")
    public R get(@PathVariable String id) {
        Role role = roleService.getById(id);
        return R.success().data("item", role);
    }

    @ApiOperation(value = "新增角色")
    @PostMapping
    public R save(@RequestBody Role role) {
        roleService.save(role);
        return R.success();
    }

    @ApiOperation(value = "修改角色")
    @PutMapping
    public R updateById(@RequestBody Role role) {
        roleService.updateById(role);
        return R.success();
    }

    @ApiOperation(value = "删除角色")
    @DeleteMapping("/{id}")
    public R remove(@PathVariable String id) {
        roleService.removeById(id);
        return R.success();
    }

    @ApiOperation(value = "根据id列表删除角色")
    @DeleteMapping("/batchRemove")
    public R batchRemove(@RequestBody List<String> idList) {
        roleService.removeByIds(idList);
        return R.success();
    }
}

