package com.zbinyds.eduService.mapper;

import com.zbinyds.eduService.pojo.EduCourseDescription;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 课程简介 Mapper 接口
 * </p>
 *
 * @author zbinyds
 * @since 2022-09-19
 */

@Repository
public interface EduCourseDescriptionMapper extends BaseMapper<EduCourseDescription> {

}
