package com.zbinyds.rabc.mapper;

import com.zbinyds.rabc.pojo.Permission;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 权限 Mapper 接口
 * </p>
 *
 * @author zbinyds
 * @since 2022-10-02
 */
public interface PermissionMapper extends BaseMapper<Permission> {

    /**
     * 根据用户id查询该用户的所有权限（多表查询。用户角色表-角色权限表-权限表）
     *
     * @param userId：用户id
     * @return：返回该用户所拥有的权限列表
     */
    List<Permission> selectPermissionByUserId(@Param("userId") String userId);

    /**
     * 查询所有权限值
     *
     * @return
     */
    List<String> selectAllPermissionValue();

    /**
     * 根据用户id查询该用户所拥有权限的权限值
     *
     * @param id：用户id
     * @return
     */
    List<String> selectPermissionValueByUserId(String id);
}
