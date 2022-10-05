package com.zbinyds.eduService.pojo.vo.subject;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author zbinyds
 * @time 2022/09/18 18:32
 * <p>
 * 发布课程-编辑课程基本信息-课程类别-二级分类下拉框需要的Vo对象
 */

@ApiModel(value = "二级分类菜单", description = "课程类别下拉框二级分类展示")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TwoSubjectVo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "二级分类ID")
    private String id;

    @ApiModelProperty(value = "二级分类标题")
    private String title;
}
