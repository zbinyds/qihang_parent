package com.zbinyds.ucenter.service;

import com.zbinyds.ucenter.pojo.Member;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zbinyds.ucenter.pojo.vo.RegisterVo;

/**
 * <p>
 * 会员表 服务类
 * </p>
 *
 * @author zbinyds
 * @since 2022-09-26
 */
public interface MemberService extends IService<Member> {

    /**
     * 用户登录
     * @param member：封装好的member对象
     * @return
     */
    String login(Member member);

    /**
     * 用户注册
     * @param registerVo：封装好的vo对象
     * @return
     */
    boolean register(RegisterVo registerVo);

    /**
     * 根据openId查询用户
     * @param openId
     * @return
     */
    Member getOpenIdMember(String openId);

    /**
     * 根据日期查询系统注册人数
     * @param date：日期
     * @return：返回注册人数。
     */
    Integer getRegisterNum(String date);
}
