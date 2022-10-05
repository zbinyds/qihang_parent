package com.zbinyds.ucenter.mapper;
import com.zbinyds.ucenter.pojo.Member;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 会员表 Mapper 接口
 * </p>
 *
 * @author zbinyds
 * @since 2022-09-26
 */
public interface MemberMapper extends BaseMapper<Member> {

    /**
     * 查询某天系统的注册人数
     * @param date：日期（格式为2022-08-11）
     * @return：返回注册人数
     */
    Integer getCount(String date);
}
