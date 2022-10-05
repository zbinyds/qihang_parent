package com.zbinyds.eduService.controller;


import com.zbinyds.R;
import com.zbinyds.eduService.pojo.EduChapter;
import com.zbinyds.eduService.pojo.vo.chapter.ChapterVo;
import com.zbinyds.eduService.service.EduChapterService;
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
 * 课程 前端控制器
 * </p>
 *
 * @author zbinyds
 * @since 2022-09-19
 */

@Api(tags = "章节管理")
@RestController
@RequestMapping("/eduService/chapter")
//@CrossOrigin
public class EduChapterController {
    @Autowired
    private EduChapterService chapterService;

    @ApiOperation("获取课程中所有章节及章节对应的小节")
    @GetMapping("/getAllChapter/{courseId}")
    public R getAllChapter(@PathVariable String courseId) {
        List<ChapterVo> list = chapterService.getChapterAndVideo(courseId);
        return Objects.isNull(list) ? R.failed().message("获取数据失败！") : R.success().data("list", list);
    }

    @ApiOperation("添加章节")
    @PostMapping
    public R save(@RequestBody EduChapter eduChapter){
        if (StringUtils.isEmpty(eduChapter.getTitle()) || StringUtils.isEmpty(eduChapter.getSort())){
            throw new QiHangException("20001","必填参数缺失！");
        }
        boolean isSuccess = chapterService.save(eduChapter);
        return isSuccess ? R.success().message("添加课程章节成功！") : R.failed().message("添加课程章节失败！");
    }

    @ApiOperation("删除章节")
    @DeleteMapping("/{chapterId}")
    public R remove(@PathVariable String chapterId){
        if (StringUtils.isEmpty(chapterId)){
            throw new QiHangException("20001","必填参数缺失！");
        }
        boolean isSuccess = chapterService.removeChapter(chapterId);
        return isSuccess ? R.success().message("删除课程章节成功！") : R.failed().message("删除课程章节失败！");
    }

    @ApiOperation("修改章节")
    @PutMapping("/{chapterId}")
    public R update(@PathVariable String chapterId,@RequestBody EduChapter eduChapter){
        eduChapter.setId(chapterId);
        boolean isSuccess = chapterService.updateById(eduChapter);
        return isSuccess ? R.success().message("修改课程章节成功！") : R.failed().message("修改课程章节失败！");
    }

    @ApiOperation("根据章节id查询章节")
    @GetMapping("/{chapterId}")
    public R getById(@PathVariable String chapterId){
        EduChapter chapter = chapterService.getById(chapterId);
        return !Objects.isNull(chapter) ? R.success().message("查询成功！").data("chapter",chapter) : R.failed().message("查询失败！");
    }
}

