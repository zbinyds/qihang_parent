package com.zbinyds.eduService.pojo.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * @author zbinyds
 * @time 2022/09/18 11:42
 *
 * 用于接收excel数据的实体类
 */

@Data
public class SubjectData {
    @ExcelProperty(index = 0)
    private String oneSubjectName;

    @ExcelProperty(index = 1)
    private String twoSubjectName;
}
