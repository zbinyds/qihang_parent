package com.zbinyds.easyExcel;

import com.alibaba.excel.EasyExcel;
import org.junit.Test;

import java.util.ArrayList;

/**
 * @author zbinyds
 * @time 2022/09/17 23:01
 */
public class easyExcelTest {
    /**
     * 测试easyExcel写功能
     */
    @Test
    public void write(){
        String fileName = "F:\\write.xlsx";
        ArrayList<DemoData> list = new ArrayList<>();
        for (int i = 1; i <= 1000000; i++) {
            DemoData demoData = new DemoData();
            demoData.setStuNo(i+"");
            demoData.setStuName("mary" + i);
            list.add(demoData);
        }
        EasyExcel.write(fileName,DemoData.class).sheet("学生信息").doWrite(list);
    }

    /**
     * 测试easyExcel读功能
     */
    @Test
    public void read(){
        String fileName = "F:\\write.xlsx";
        EasyExcel.read(fileName,DemoData.class,new EasyExcelListener()).sheet().doRead();
    }
}
