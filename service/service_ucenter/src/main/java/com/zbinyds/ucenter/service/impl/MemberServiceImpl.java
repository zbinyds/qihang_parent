package com.zbinyds.ucenter.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zbinyds.JwtUtils;
import com.zbinyds.MD5;
import com.zbinyds.servicebase.exceptionHandler.QiHangException;
import com.zbinyds.ucenter.mapper.MemberMapper;
import com.zbinyds.ucenter.pojo.Member;
import com.zbinyds.ucenter.pojo.vo.RegisterVo;
import com.zbinyds.ucenter.service.MemberService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.jdbc.UncategorizedSQLException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.Objects;

/**
 * <p>
 * 会员表 服务实现类
 * </p>
 *
 * @author zbinyds
 * @since 2022-09-26
 */
@Service
public class MemberServiceImpl extends ServiceImpl<MemberMapper, Member> implements MemberService {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Override
    public String login(Member member) {
        if (Objects.isNull(member)) throw new QiHangException("20001", "非法的请求！");

        String mobile = member.getMobile(); // 手机号
        String password = member.getPassword(); // 密码
        if (StringUtils.isEmpty(mobile) || StringUtils.isEmpty(password))
            throw new QiHangException("20001", "用户名或密码输入错误！");

        // 获取当前登录会员基本信息
        LambdaQueryWrapper<Member> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Member::getMobile, mobile);
        member = this.getOne(queryWrapper);

        /**
         * 登录失败的几种情况
         */
        // 会员合法性校验
        if (Objects.isNull(member))
            throw new QiHangException("20001", "用户名或密码输入错误！");
        // 密码校验
        if (!MD5.encrypt(password).equals(member.getPassword()))
            throw new QiHangException("20001", "用户名或密码输入错误！");
        // 会员状态校验
        if (member.getIsDisabled())
            throw new QiHangException("20001", "该用户已封号！");

        // 成功登录，封装token并返回。
        String token = JwtUtils.getJwtToken(member.getId(), member.getNickname());
        return token;
    }

    @Transactional // 开启事务支持
    @Override
    public boolean register(RegisterVo registerVo) {
        if (Objects.isNull(registerVo)) throw new QiHangException("20001", "非法的请求！");

        String nickname = registerVo.getNickname(); // 用户名
        String password = registerVo.getPassword(); // 密码
        String mobile = registerVo.getMobile(); // 手机号
        String code = registerVo.getCode(); // 验证码
        // 必填参数校验
        if (StringUtils.isEmpty(nickname) || StringUtils.isEmpty(password)
                || StringUtils.isEmpty(mobile) || StringUtils.isEmpty(code))
            throw new QiHangException("20001", "请填写注册信息！");

        // 短信验证码校验
        String redisCode = redisTemplate.opsForValue().get("code::" + mobile);
        if (!code.equals(redisCode)) throw new QiHangException("20001", "验证码错误！");

        // 手机号是否重复校验
        LambdaQueryWrapper<Member> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Member::getMobile, mobile);
        Integer count = baseMapper.selectCount(queryWrapper);
        if (count > 0) {
            throw new QiHangException("20001", "该用户已注册！");
        }

        // 注册成功。将用户信息添加到数据库中
        Member member = new Member();
        member.setNickname(nickname);
        member.setPassword(MD5.encrypt(password));
        member.setMobile(mobile);
        member.setAvatar("https://edu-qihang.oss-cn-shenzhen.aliyuncs.com/teacher/default.jpg"); // 设置默认头像
        int row = baseMapper.insert(member);

        // 返回提示信息
        return row > 0;
    }

    @Override
    public Member getOpenIdMember(String openId) {
        LambdaQueryWrapper<Member> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Member::getOpenid,openId);
        Member member = this.getOne(queryWrapper);
        return member;
    }

    @Override
    public Integer getRegisterNum(String date) {
        try {
            return baseMapper.getCount(date);
        } catch (UncategorizedSQLException e) {
            throw new QiHangException("20001","日期不合法！");
        }
    }
}
