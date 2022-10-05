package com.zbinyds.eduStatistics.service;

import com.zbinyds.eduStatistics.pojo.StatisticsDaily;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * <p>
 * 网站统计日数据 服务类
 * </p>
 *
 * @author zbinyds
 * @since 2022-10-01
 */
public interface StatisticsDailyService extends IService<StatisticsDaily> {

    /**
     * 统计网站日活量
     * @param date：日期
     */
    void getDaily(String date);

    /**
     * 按条件返回统计数据
     * @param type：统计的字段类型（注册人数、登陆人数...）
     * @param start：开始日期
     * @param end：结束日期
     * @return：返回封装好的数据。返回null表示出错了。
     */
    Map<String, Object> getData(String type, String start, String end);
}
