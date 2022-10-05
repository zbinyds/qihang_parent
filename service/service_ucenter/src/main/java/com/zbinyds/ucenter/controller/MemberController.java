package com.zbinyds.ucenter.controller;


import com.zbinyds.JwtUtils;
import com.zbinyds.R;
import com.zbinyds.orderVo.MemberOrder;
import com.zbinyds.servicebase.exceptionHandler.QiHangException;
import com.zbinyds.ucenter.pojo.Member;
import com.zbinyds.ucenter.pojo.vo.RegisterVo;
import com.zbinyds.ucenter.service.MemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 会员表 前端控制器
 * </p>
 *
 * @author zbinyds
 * @since 2022-09-26
 */

@Api(tags = "前台会员管理")
@RestController
@RequestMapping("/ucenter/member")
//@CrossOrigin // 允许跨域访问
public class MemberController {

    @Autowired
    private MemberService memberService;

    @ApiOperation("会员登录")
    @PostMapping("/login")
    public R login(@RequestBody Member member) {
        String token = memberService.login(member);
        return R.success().data("token", token);
    }

    @ApiOperation("会员注册")
    @PostMapping("/register")
    public R register(@RequestBody RegisterVo registerVo) {
        boolean isRegister = memberService.register(registerVo);
        return isRegister ? R.success().message("注册成功！") : R.failed().message("注册失败！");
    }

    @ApiOperation("根据token获取当前会员信息")
    @GetMapping("/getMemberInfo")
    public R getMemberInfo(HttpServletRequest request) {
        String memberId;
        try {
            memberId = JwtUtils.getMemberIdByJwtToken(request);
            // member为空，表示token不合法
            if (!StringUtils.isEmpty(memberId)) {
                Member member = memberService.getById(memberId);
                return R.success().data("UserInfo", member);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        throw new QiHangException("20001", "非法的token！");
    }

    @ApiOperation("通过会员id查询会员信息-order服务调用")
    @PostMapping("/getMemberOrder/{memberId}")
    public MemberOrder getMemberOrder(@PathVariable String memberId) {
        Member member = memberService.getById(memberId);
        MemberOrder memberOrder = new MemberOrder();
        BeanUtils.copyProperties(member,memberOrder);
        return memberOrder;
    }

    @ApiOperation("查询某日项目注册人数-statistics服务调用")
    @PostMapping("/getRegisterNum/{date}")
    public Integer getRegisterNum(@PathVariable String date) {
        return memberService.getRegisterNum(date);
    }
}

