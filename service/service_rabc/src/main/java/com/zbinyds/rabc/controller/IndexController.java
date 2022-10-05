package com.zbinyds.rabc.controller;

import com.alibaba.fastjson.JSONObject;
import com.zbinyds.R;
import com.zbinyds.rabc.service.IndexService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin/rabc/index")
//@CrossOrigin
public class IndexController {

    @Autowired
    private IndexService indexService;

    /**
     * 根据token获取用户信息
     */
    @ApiOperation("根据token获取用户信息")
    @GetMapping("info")
    public R info(){
        //获取当前登录用户用户名
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        Map<String, Object> userInfo = indexService.getUserInfo(username);
        return R.success().data(userInfo);
    }

    /**
     * 获取菜单
     * @return
     */
    @ApiOperation("获取菜单")
    @GetMapping("menu")
    public R getMenu(){
        //获取当前登录用户用户名
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        List<JSONObject> permissionList = indexService.getMenu(username);
        return R.success().data("permissionList", permissionList);
    }

    @ApiOperation("退出登录")
    @PostMapping("logout")
    public R logout(){
        return R.success();
    }

}
