package com.zbinyds.eduStatistics.schedule;

import com.zbinyds.eduStatistics.service.StatisticsDailyService;
import com.zbinyds.eduStatistics.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author zbinyds
 * @time 2022/10/01 17:10
 *
 * 定时任务
 */

@Component
public class ScheduledTask {

    @Autowired
    private StatisticsDailyService dailyService;

    /**
     * 定时任务。在每天0:00调用接口，统计前一天的注册人数。
     */
    @Scheduled(cron = "0 0 0 * * ?")
    public void task(){
        // 利用工具类获取到前一天的日期
        String yesterday = DateUtil.formatDate(DateUtil.addDays(new Date(), -1));
        dailyService.getDaily(yesterday);
    }
}
