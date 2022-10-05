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
 * 发布课程-创建课程大纲-显示课程章节列表中小节所需要的Vo对象
 */

@ApiModel(value = "章节小节", description = "课程中每个章节对应的小节")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VideoVo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "小节id")
    private String id;

    @ApiModelProperty(value = "小节标题")
    private String title;

    @ApiModelProperty(value = "视频是否免费")
    private Integer isFree;

    @ApiModelProperty(value = "视频id")
    private String VideoSourceId;
}
