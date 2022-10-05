package com.zbinyds.eduService.mapper;

import com.zbinyds.eduService.pojo.EduVideo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 课程视频 Mapper 接口
 * </p>
 *
 * @author zbinyds
 * @since 2022-09-19
 */
@Repository
public interface EduVideoMapper extends BaseMapper<EduVideo> {

    /**
     * 根据课程id删除该课程下所有的小节
     * @param courseId：课程id
     */
    int deleteByCourseId(@Param("courseId") String courseId);
}
