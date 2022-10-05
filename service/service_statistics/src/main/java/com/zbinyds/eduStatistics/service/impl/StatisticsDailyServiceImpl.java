package com.zbinyds.eduStatistics.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zbinyds.eduStatistics.client.UcenterClient;
import com.zbinyds.eduStatistics.pojo.StatisticsDaily;
import com.zbinyds.eduStatistics.mapper.StatisticsDailyMapper;
import com.zbinyds.eduStatistics.service.StatisticsDailyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zbinyds.servicebase.exceptionHandler.QiHangException;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * <p>
 * 网站统计日数据 服务实现类
 * </p>
 *
 * @author zbinyds
 * @since 2022-10-01
 */

@Service
public class StatisticsDailyServiceImpl extends ServiceImpl<StatisticsDailyMapper, StatisticsDaily> implements StatisticsDailyService {

    @Autowired
    private UcenterClient client;

    @Transactional
    public void getDaily(String date) {
        // 获取该日的注册人数
        Integer registerNum = client.getRegisterNum(date);
        if (Objects.isNull(registerNum)) throw new QiHangException("20001", "请求失败，目标服务器状态异常！");

        // 添加前，删除相同日期的记录
        LambdaQueryWrapper<StatisticsDaily> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(StatisticsDaily::getDateCalculated, date);
        this.remove(queryWrapper);

        // 将该天的统计记录写入统计表中
        StatisticsDaily daily = new StatisticsDaily();
        daily.setRegisterNum(registerNum);
        daily.setDateCalculated(date);
        // TODO 测试阶段，其他字段暂时使用随机数
        daily.setLoginNum(RandomUtils.nextInt(10, 200));
        daily.setVideoViewNum(RandomUtils.nextInt(10, 200));
        daily.setCourseNum(RandomUtils.nextInt(10, 200));
        this.save(daily);
    }

    @Override
    public Map<String, Object> getData(String type, String begin, String end) {
        // 查询数据库，获取需要的数据。
        QueryWrapper<StatisticsDaily> queryWrapper = new QueryWrapper<>();
        queryWrapper.between("date_calculated", begin, end);
        queryWrapper.select("date_calculated", type); // 只查询日期和传入的类型字段
        List<StatisticsDaily> dailyList = this.list(queryWrapper);

        // 将需要的数据封装成list集合
        ArrayList<String> dateList = new ArrayList<>();
        ArrayList<Integer> countList = new ArrayList<>();
        for (StatisticsDaily daily : dailyList) {
            dateList.add(daily.getDateCalculated());
            if ("login_num".equals(type)) { // 表示统计的是登录人数
                countList.add(daily.getLoginNum());
            } else if ("register_num".equals(type)) { // 表示统计的是注册人数
                countList.add(daily.getRegisterNum());
            } else if ("video_view_num".equals(type)) { // 表示统计的是视频观看人数
                countList.add(daily.getVideoViewNum());
            } else { // 表示统计的是课程浏览人数
                countList.add(daily.getCourseNum());
            }
        }
        // 数据最终封装
        HashMap<String, Object> map = new HashMap<>();
        if (dateList.size() > 0 && countList.size() > 0){
            map.put("dateList", dateList);
            map.put("countList", countList);
            return map;
        }
        return null;
    }
}
