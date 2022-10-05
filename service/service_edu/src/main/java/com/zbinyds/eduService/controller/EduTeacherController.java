package com.zbinyds.eduService.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zbinyds.R;
import com.zbinyds.eduService.pojo.EduTeacher;
import com.zbinyds.eduService.pojo.vo.TeacherVo;
import com.zbinyds.eduService.service.EduTeacherService;
import com.zbinyds.servicebase.exceptionHandler.QiHangException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author zbinyds
 * @since 2022-09-13
 */
@Api(tags = "讲师管理") // Swagger中文提示
@RestController
@RequestMapping("/eduService/teacher")
//@CrossOrigin // 允许跨域访问
public class EduTeacherController {
    @Autowired
    private EduTeacherService teacherService;

    /**
     * 查询所有讲师。
     *
     * @return：返回讲师列表
     */
    @ApiOperation("查询所有讲师列表") // Swagger中文提示
    @GetMapping("/findAll")
    public R list() {
        List<EduTeacher> teachers = teacherService.list(null);
        return R.success().data("items", teachers);
    }

    /**
     * 根据id删除讲师（逻辑删除）
     *
     * @param id：讲师ID
     * @return：返回登录成功/失败（实际上不会有失败的场景出现，因为使用的是逻辑删除，执行的sql为update语句，不论怎样都是返回true）
     */
    @ApiOperation("根据Id删除讲师") // Swagger中文提示
    @DeleteMapping("/{id}")
    public R delete(@PathVariable() String id) {
        // 判断讲师id是否为空
        if (!StringUtils.hasLength(id)) {
            throw new QiHangException("20002", "未传入必填参数！");
        }
        boolean bool = teacherService.removeById(id);
        return bool ? R.success().message("删除讲师成功！") : R.failed();
    }

    /**
     * 讲师分页信息
     *
     * @param page：当前页
     * @param pageSize：每页记录数
     * @return：返回分页讲师信息
     */
    @ApiOperation("获取讲师分页信息")
    @GetMapping("/pageTeacher/{page}/{pageSize}")
    public R page(@PathVariable Integer page, @PathVariable Integer pageSize) {
        // 参数非空校验
        if (Objects.isNull(page) || Objects.isNull(pageSize)) {
            throw new QiHangException("20002", "未传入必填参数！");
        }
        Page<EduTeacher> teacherPage = new Page<>(page, pageSize);
        teacherService.page(teacherPage, null);
        return R.success().data("total", teacherPage.getTotal()).data("rows", teacherPage.getRecords());
    }

    /**
     * 带条件的分页查询-讲师信息
     *
     * @param page：当前页
     * @param pageSize：每页显示的记录数
     * @param teacherVo：封装好的条件信息（姓名、级别、加入时间范围查询）
     * @return：返回条件查询后的讲师分页信息
     */
    @ApiOperation("带条件查询讲师分页信息")
    @PostMapping("/pageTeacherCondition/{page}/{pageSize}")
    public R pageCondition(@PathVariable Integer page,
                           @PathVariable Integer pageSize,
                           @RequestBody(required = false) TeacherVo teacherVo) {
        // 参数非空校验
        if (Objects.isNull(page) || Objects.isNull(pageSize)) {
            throw new QiHangException("20002", "未传入必填参数！");
        }
        Page<EduTeacher> teacherPage = teacherService.pageCondition(page, pageSize, teacherVo);
        return R.success().data("total", teacherPage.getTotal()).data("rows", teacherPage.getRecords());
    }

    /**
     * 添加讲师
     *
     * @param eduTeacher：需要添加的讲师信息
     * @return
     */
    @ApiOperation("添加讲师")
    @PostMapping
    public R add(@RequestBody EduTeacher eduTeacher) {
        // 参数eduTeacher非空校验
        if (Objects.isNull(eduTeacher)) {
            throw new QiHangException("20002", "未传入必填参数！");
        }
        return teacherService.save(eduTeacher) ? R.success().message("添加讲师成功") : R.failed().message("添加讲师失败");
    }

    /**
     * 通过id查询讲师
     *
     * @param id：讲师id
     * @return
     */
    @ApiOperation("通过id查询讲师")
    @GetMapping("/{id}")
    public R getTeacher(@PathVariable String id) {
        if (StringUtils.isEmpty(id)) {
            throw new QiHangException("20002", "未传入必填参数！");
        }
        EduTeacher eduTeacher = teacherService.getById(id);
        return !Objects.isNull(eduTeacher) ? R.success().data("teacher", eduTeacher) : R.success().message("未查询到相关讲师！");
    }

    /**
     * 修改讲师
     *
     * @param id：讲师id
     * @param eduTeacher：需要修改的讲师信息
     * @return
     */
    @ApiOperation("修改讲师")
    @PutMapping("/{id}")
    public R update(@PathVariable String id, @RequestBody EduTeacher eduTeacher) {
        // 参数非空校验
        if (StringUtils.isEmpty(id) || Objects.isNull(eduTeacher)) {
            throw new QiHangException("20002", "未传入必填参数！");
        }
        eduTeacher.setId(id);
        boolean flag = teacherService.updateById(eduTeacher);
        return flag ? R.success().message("修改成功") : R.failed().message("修改失败");
    }
}

