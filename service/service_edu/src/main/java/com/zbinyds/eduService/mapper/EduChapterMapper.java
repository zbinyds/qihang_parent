package com.zbinyds.eduService.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zbinyds.eduService.pojo.EduChapter;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 课程 Mapper 接口
 * </p>
 *
 * @author zbinyds
 * @since 2022-09-19
 */
@Repository
public interface EduChapterMapper extends BaseMapper<EduChapter> {

    /**
     * 根据课程id删除该课程所有章节
     * @param courseId：课程id
     */
    int deleteByCourseId(@Param("courseId") String courseId);
}
