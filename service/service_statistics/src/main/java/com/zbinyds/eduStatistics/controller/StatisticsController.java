package com.zbinyds.eduStatistics.controller;


import com.zbinyds.R;
import com.zbinyds.eduStatistics.service.StatisticsDailyService;
import com.zbinyds.eduStatistics.utils.IpInfoUtil;
import com.zbinyds.servicebase.exceptionHandler.QiHangException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.ObjectStreamClass;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * 网站统计日数据 前端控制器
 * </p>
 *
 * @author zbinyds
 * @since 2022-10-01
 */
@Api(tags = "统计日数据接口管理")
@RestController
@RequestMapping("/eduStatistics/daily")
//@CrossOrigin
public class StatisticsController {

    @Autowired
    private StatisticsDailyService dailyService;

    @ApiOperation("统计日活量记录")
    @PostMapping("/{date}")
    public R getStatistics(@PathVariable String date, HttpServletRequest request) {
        if (StringUtils.isEmpty(date) || !date.matches("(\\d{4})-(1[0,1,2]|0?\\d)[-/](3[0,1]|[1,2]\\d|0?\\d)"))
            return R.failed().message("输入日期不合法！");
        dailyService.getDaily(date);
        String ip = IpInfoUtil.getIpAddress(request);
        String ipAddr = IpInfoUtil.getAlibaba(ip);
        return R.success().message("统计数据成功！").data("ip", ip).data("ipAddr", ipAddr);
    }

    @ApiOperation("按条件返回统计数据-图表绘制使用")
    @GetMapping("/data/{type}/{begin}/{end}")
    public R getData(@PathVariable String type, @PathVariable String begin, @PathVariable String end) {
        if (!("login_num".equals(type) || "register_num".equals(type) || "video_view_num".equals(type) || "course_num".equals(type)))
            throw new QiHangException("20001", "参数异常！");
        Map<String, Object> map = dailyService.getData(type, begin, end);
        return !Objects.isNull(map) ? R.success().data(map) : R.failed().message("未查询到相关记录！");
    }
}

