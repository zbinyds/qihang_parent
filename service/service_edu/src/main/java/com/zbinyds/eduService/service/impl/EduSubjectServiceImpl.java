package com.zbinyds.eduService.service.impl;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.exception.ExcelCommonException;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.zbinyds.eduService.pojo.EduSubject;
import com.zbinyds.eduService.mapper.EduSubjectMapper;
import com.zbinyds.eduService.pojo.excel.SubjectData;
import com.zbinyds.eduService.pojo.excel.SubjectListener;
import com.zbinyds.eduService.pojo.vo.subject.OneSubjectVo;
import com.zbinyds.eduService.pojo.vo.subject.TwoSubjectVo;
import com.zbinyds.eduService.service.EduSubjectService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zbinyds.servicebase.exceptionHandler.QiHangException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 课程科目 服务实现类
 * </p>
 *
 * @author zbinyds
 * @since 2022-09-18
 */

@Service
public class EduSubjectServiceImpl extends ServiceImpl<EduSubjectMapper, EduSubject> implements EduSubjectService {

    @Override
    public void addSubject(MultipartFile file, EduSubjectService subjectService) {

        try {
            // 使用EasyExcel读取excel文件，并将读取的数据添加到数据库中
            EasyExcel
                    .read(file.getInputStream(), SubjectData.class, new SubjectListener(subjectService))
                    .sheet()
                    .doRead();
        } catch (IOException e) {
            throw new QiHangException("20001","获取excel文件输入流发生了异常！");
        } catch (ExcelCommonException e){
            throw new QiHangException("20001","文件类型不匹配！");
        }
    }

    @Override
    @Transactional // 多个表进行操作，需要支持事务
    public List<OneSubjectVo> getAllSubject() {
        // 需要构建的返回对象
        ArrayList<OneSubjectVo> list = new ArrayList<>();

        // 获取所有的一级分类
        LambdaQueryWrapper<EduSubject> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(EduSubject::getParentId,"0");
        List<EduSubject> oneSubjectList = this.list(queryWrapper);

        // 获取每个一级分类对应的二级分类
        for (EduSubject oneSubject : oneSubjectList) {
            String id = oneSubject.getId();
            LambdaQueryWrapper<EduSubject> lambdaQueryWrapper = new LambdaQueryWrapper<>();
            lambdaQueryWrapper.eq(EduSubject::getParentId,id);
            List<EduSubject> twoSubjectList = this.list(lambdaQueryWrapper);

            // 封装二级分类(children属性)
            ArrayList<TwoSubjectVo> twoSubjectVos = new ArrayList<>();
            for (EduSubject twoSubject : twoSubjectList) {
                twoSubjectVos.add(new TwoSubjectVo(twoSubject.getId(),twoSubject.getTitle()));
            }
            // 将封装好的一级分类对象进行添加
            list.add(new OneSubjectVo(oneSubject.getId(),oneSubject.getTitle(),twoSubjectVos));
        }
        // 返回封装好的完全体集合（包含所有的课程基本信息）
        return list;
    }
}
