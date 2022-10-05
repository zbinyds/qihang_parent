package com.zbinyds.eduService.pojo.excel;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.zbinyds.eduService.pojo.EduSubject;
import com.zbinyds.eduService.service.EduSubjectService;
import com.zbinyds.servicebase.exceptionHandler.QiHangException;
import lombok.extern.log4j.Log4j;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

/**
 * @author zbinyds
 * @time 2022/09/18 11:50
 *
 * EasyExcel监听器
 */

public class SubjectListener extends AnalysisEventListener<SubjectData> {
    // SubjectListener：不能交给spring容器进行管理，所以我们需要手动通过构造器的方式获取EduSubjectService对象。
    public EduSubjectService subjectService;

    public SubjectListener(EduSubjectService subjectService) {
        this.subjectService = subjectService;
    }

    public SubjectListener() {
    }

    // 读取excel文件。按行读取
    @Transactional
    @Override
    public void invoke(SubjectData subjectData, AnalysisContext analysisContext) {
        // 判断传入的excel文件中是否有数据
        if (Objects.isNull(subjectData)) {
            throw new QiHangException("20001", "传入的Excel文件中未包含数据！");
        }

        // 查询数据库中对应一级分类数据
        EduSubject oneSubject = existOneSubject(subjectService, subjectData.getOneSubjectName());
        // 此时一级分类不重复（可以添加）
        if (Objects.isNull(oneSubject)) {
            oneSubject = new EduSubject();
            oneSubject.setTitle(subjectData.getOneSubjectName());
            oneSubject.setParentId("0");
            subjectService.save(oneSubject);
        }

        String pid = oneSubject.getId(); // 获取一级分类id值
        // 查询数据库中对应二级分类数据
        EduSubject twoSubject = existTwoSubject(subjectService, subjectData.getTwoSubjectName(), pid);
        // 此时二级分类不重复（可以添加）
        if (Objects.isNull(twoSubject)){
            twoSubject = new EduSubject();
            twoSubject.setTitle(subjectData.getTwoSubjectName());
            twoSubject.setParentId(pid);
            subjectService.save(twoSubject);
        }

    }

    // 判断一级分类在数据库中是否重复。
    private EduSubject existOneSubject(EduSubjectService subjectService, String name) {
        LambdaQueryWrapper<EduSubject> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(EduSubject::getTitle, name);
        queryWrapper.eq(EduSubject::getParentId, "0");
        EduSubject oneSubject = subjectService.getOne(queryWrapper);
        return oneSubject;
    }

    // 判断二级分类在数据库中是否重复。
    private EduSubject existTwoSubject(EduSubjectService subjectService, String name, String pid) {
        LambdaQueryWrapper<EduSubject> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(EduSubject::getTitle, name);
        queryWrapper.eq(EduSubject::getParentId, pid);
        EduSubject twoSubject = subjectService.getOne(queryWrapper);
        return twoSubject;
    }

    // 读取完文件后执行的方法
    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        System.out.println("文件读取完毕~！");
    }
}
