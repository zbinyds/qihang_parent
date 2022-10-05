package com.zbinyds.eduService.controller;

import com.zbinyds.JwtUtils;
import com.zbinyds.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author zbinyds
 * @time 2022/09/16 17:07
 *
 * 已弃用。使用SpringSecurity
 */

@Api(tags = "后台登录")
@RestController
@RequestMapping("/eduService/user")
//@CrossOrigin // 允许跨域访问
public class EduLoginController {

    /**
     * 后台用户登录
     * @return
     */
    @ApiOperation("后台用户登录")
    @PostMapping("/login")
    public R login() {
        return R.success().data("token","admin");
    }

    /**
     * 获取登录用户的基本信息
     * @return
     */
    @ApiOperation("获取登录用户信息")
    @GetMapping("/info")
    public R info() {
        return R
                .success()
                .data("roles","admin") // 用户角色
                .data("name","admin") // 用户名
                .data("avatar","https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif"); // 用户头像
    }

    /**
     * 后台用户退出登录
     * @return
     */
    @ApiOperation("后台用户退出登录")
    @PostMapping("/logout")
    public R logout(HttpServletRequest request) {
        // TODO：将token设置为过期
        return R.success();
    }
}
