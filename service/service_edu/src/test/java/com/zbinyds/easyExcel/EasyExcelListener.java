package com.zbinyds.easyExcel;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;

import java.util.Map;

/**
 * @author zbinyds
 * @time 2022/09/17 23:12
 * <p>
 *
 * easyExcel监听器（读取时需要用到）
 */
public class EasyExcelListener extends AnalysisEventListener<DemoData> {
    // 一行一行读取xlsx文件中的数据
    @Override
    public void invoke(DemoData demoData, AnalysisContext analysisContext) {
        System.out.println(demoData);
    }

    // 读取表头信息
    @Override
    public void invokeHeadMap(Map<Integer, String> headMap, AnalysisContext context) {
        System.out.println("表头：" + headMap);
    }

    // 读取完之后执行
    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
    }
}
