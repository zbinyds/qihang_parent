package com.zbinyds.eduService.pojo.vo.chapter;

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
 * @time 2022/09/20 12:58
 * <p>
 * 发布课程-创建课程大纲-显示课程章节列表所需要的Vo对象
 */

@ApiModel(value = "课程章节", description = "课程对应章节")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChapterVo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "章节id")
    private String id;

    @ApiModelProperty(value = "章节标题")
    private String title;

    @ApiModelProperty(value = "章节所对应的小节")
    private List<VideoVo> children = new ArrayList<>();
}
