package com.zbinyds.rabc.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zbinyds.MD5;
import com.zbinyds.R;
import com.zbinyds.rabc.pojo.User;
import com.zbinyds.rabc.service.RoleService;
import com.zbinyds.rabc.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author zbinyds
 * @since 2022-10-02
 */

@Api(tags = "管理用户接口管理")
@RestController
@RequestMapping("/admin/rabc/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @ApiOperation(value = "获取管理用户分页列表")
    @GetMapping("{page}/{limit}")
    public R index(
            @ApiParam(name = "page", value = "当前页码", required = true)
            @PathVariable Long page,

            @ApiParam(name = "limit", value = "每页记录数", required = true)
            @PathVariable Long limit,

            @ApiParam(name = "courseQuery", value = "查询对象", required = false)
                    User userQueryVo) {
        Page<User> userPage = new Page<>(page, limit);
        // 构建查询条件
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(!StringUtils.isEmpty(userQueryVo.getUsername()), User::getUsername, userQueryVo.getUsername());
        // 分页条件查询
        userService.page(userPage, queryWrapper);
        return R.success().data("items", userPage.getRecords()).data("total", userPage.getTotal());
    }

    @ApiOperation("根据用户id获取用户信息")
    @GetMapping("/{id}")
    public R getById(@PathVariable String id){
        User user = userService.getById(id);
        return R.success().data("user",user);
    }

    @ApiOperation(value = "新增管理用户")
    @PostMapping("/save")
    public R save(@RequestBody User user) {
        user.setPassword(MD5.encrypt(user.getPassword()));  // md5加密
        userService.save(user);
        return R.success();
    }

    @ApiOperation(value = "修改管理用户")
    @PutMapping("/update")
    public R updateById(@RequestBody User user) {
        userService.updateById(user);
        return R.success();
    }

    @ApiOperation(value = "删除管理用户")
    @DeleteMapping("/remove/{id}")
    public R remove(@PathVariable String id) {
        userService.removeById(id);
        return R.success();
    }

    @ApiOperation(value = "根据id列表删除管理用户-批量删除")
    @DeleteMapping("/batchRemove")
    public R batchRemove(@RequestBody List<String> idList) {
        userService.removeByIds(idList);
        return R.success();
    }

    @ApiOperation(value = "根据用户id获取用户角色")
    @GetMapping("/toAssign/{userId}")
    public R toAssign(@PathVariable String userId) {
        Map<String, Object> roleMap = roleService.findRoleByUserId(userId);
        return R.success().data(roleMap);
    }

    @ApiOperation(value = "根据用户id分配角色")
    @PostMapping("/doAssign")
    public R doAssign(@RequestParam String userId, @RequestParam String[] roleId) {
        roleService.saveUserRoleRealtionShip(userId, roleId);
        return R.success();
    }
}

