package com.zbinyds.eduService.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author zbinyds
 * @time 2022/09/21 13:38
 */

@ApiModel(value = "课程发布提交",description = "课程最终提交中页面展示所需要的数据对象")
@Data
public class PublishCourseInfoVo implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "课程名")
    private String title;

    @ApiModelProperty(value = "课程图片")
    private String cover;

    @ApiModelProperty(value = "课时数")
    private Integer lessonNum;

    @ApiModelProperty(value = "一级分类")
    private String subjectLevelOne;

    @ApiModelProperty(value = "二级分类")
    private String subjectLevelTwo;

    @ApiModelProperty(value = "课程讲师")
    private String teacherName;

    @ApiModelProperty(value = "课程价格")
    private String price;//只用于显示
}
