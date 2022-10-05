package com.zbinyds.eduService.controller.front;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zbinyds.R;
import com.zbinyds.eduService.pojo.EduTeacher;
import com.zbinyds.eduService.service.EduTeacherService;
import com.zbinyds.servicebase.exceptionHandler.QiHangException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Objects;

/**
 * @author zbinyds
 * @time 2022/09/27 19:14
 */

@Api(tags = "前台名师模块接口管理")
@RestController
@RequestMapping("/eduService/teacherFront")
//@CrossOrigin // 允许跨域访问
public class TeacherFrontController {

    @Autowired
    private EduTeacherService teacherService;

    @ApiOperation("前台-分页展示讲师数据")
    @GetMapping("/teacherList/{page}/{pageSize}")
    public R getTeacherList(@PathVariable Integer page, @PathVariable Integer pageSize) {
        // 参数合法性校验
        if ((Objects.isNull(page) || page == 0) || (Objects.isNull(pageSize) || pageSize == 0))
            throw new QiHangException("20001", "参数不合法！");
        Page<EduTeacher> teacherPage = new Page<>(page, pageSize);
        Map<String, Object> map = teacherService.pageTeacherList(teacherPage);
        return !Objects.isNull(map) ? R.success().data(map) : R.failed().message("请求失败！");
    }

    @ApiOperation("前台-获取讲师详情数据")
    @GetMapping("/teacherDetail/{teacherId}")
    public R getTeacherDetail(@PathVariable String teacherId) {
        // 参数非空校验
        if (StringUtils.isEmpty(teacherId)) throw new QiHangException("20001","必填参数为空！");
        Map<String,Object> map = teacherService.getTeacherDetailInfo(teacherId);
        return !Objects.isNull(map) ? R.success().message("请求成功！").data(map) : R.failed().message("请求失败！");
    }
}
