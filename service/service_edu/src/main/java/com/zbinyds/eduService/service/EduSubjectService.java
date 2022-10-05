package com.zbinyds.eduService.service;

import com.zbinyds.eduService.pojo.EduSubject;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zbinyds.eduService.pojo.vo.subject.OneSubjectVo;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * <p>
 * 课程科目 服务类
 * </p>
 *
 * @author zbinyds
 * @since 2022-09-18
 */
public interface EduSubjectService extends IService<EduSubject> {

    /**
     * 添加课程分类
     * @param file：excel文件对象
     * @param subjectService：用于操作数据库
     */
    void addSubject(MultipartFile file, EduSubjectService subjectService);

    /**
     * 获取所有的课程信息，包括一级分类和二级分类
     * @return：数据封装成集合返回。
     */
    List<OneSubjectVo> getAllSubject();
}
