package com.zbinyds.eduService.pojo.vo.subject;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zbinyds
 * @time 2022/09/18 18:31
 *
 * 一级分类：value Object
 * 发布课程-编辑课程基本信息-课程类别-一级分类下拉框需要的Vo对象
 */

@ApiModel(value = "一级分类菜单", description = "课程类别下拉框一级分类展示")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OneSubjectVo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "一级分类ID")
    private String id;

    @ApiModelProperty(value = "一级分类标题")
    private String title;

    @ApiModelProperty(value = "一级分类包含的二级分类")
    private List<TwoSubjectVo> children = new ArrayList<>();
}
