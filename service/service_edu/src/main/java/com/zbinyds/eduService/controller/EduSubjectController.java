package com.zbinyds.eduService.controller;


import com.zbinyds.R;
import com.zbinyds.eduService.pojo.vo.subject.OneSubjectVo;
import com.zbinyds.eduService.service.EduSubjectService;
import com.zbinyds.servicebase.exceptionHandler.QiHangException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Objects;

/**
 * <p>
 * 课程科目 前端控制器
 * </p>
 *
 * @author zbinyds
 * @since 2022-09-18
 */

@Api(tags = "课程分类管理")
@RestController
@RequestMapping("/eduService/subject")
//@CrossOrigin // 允许跨域访问
public class EduSubjectController {

    @Autowired
    private EduSubjectService subjectService;

    /**
     * 导入课程分类-通过读取Excel中课程数据，实现导入课程功能。
     *
     * @param file：Excel文件对象
     * @return：返回提示信息。
     */
    @ApiOperation("Excel导入课程分类")
    @PostMapping("/addSubject")
    public R addSubject(@RequestPart MultipartFile file) {
        // 文件大小限制，不能超过500KB
        if (file.getSize() > 512000) throw new QiHangException("20001","文件大小不能大于500kb！");
        subjectService.addSubject(file, subjectService);
        return R.success().message("导入课程成功");
    }

    /**
     * 获取所有课程分类信息
     * @return：按照前端约定好的json格式进行数据封装，并返回。
     */
    @ApiOperation("获取课程分类列表")
    @GetMapping("/getSubjectList")
    public R getSubjectList() {
        List<OneSubjectVo> list = subjectService.getAllSubject();
        return !Objects.isNull(list) ? R.success().data("list", list) : R.failed().message("获取课程信息失败");
    }
}

