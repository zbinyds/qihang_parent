package com.zbinyds.easyExcel;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * @author zbinyds
 * @time 2022/09/17 23:02
 */
@Data
public class DemoData {
    @ExcelProperty(value = "学生编号",index = 0)
    private String stuNo;
    @ExcelProperty(value = "学生姓名",index = 1)
    private String stuName;
}
