package com.zbinyds.eduOrder.controller;


import com.zbinyds.R;
import com.zbinyds.eduOrder.service.PayLogService;
import com.zbinyds.servicebase.exceptionHandler.QiHangException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * 支付日志表 前端控制器
 * </p>
 *
 * @author zbinyds
 * @since 2022-09-29
 */

@Api(tags = "订单支付接口管理")
@RestController
@RequestMapping("/eduOrder/pay")
//@CrossOrigin
public class PayLogController {

    @Autowired
    private PayLogService payLogService;

    @ApiOperation("生成微信支付二维码")
    @PostMapping("/createNative/{orderNo}")
    public R createNative(@PathVariable String orderNo) {
        if (StringUtils.isEmpty(orderNo)) throw new QiHangException("20001", "必填参数异常！");
        // 返回二维码地址以及相关参数
        Map map = payLogService.createNative(orderNo);
        return map.size() > 0 ? R.success().data(map) : R.failed().message("生成二维码失败！");
    }

    @ApiOperation("根据订单编号查询订单状态")
    @PostMapping("/queryOrderStatus/{orderNo}")
    public R queryOrderStatus(@PathVariable String orderNo) {
        // 参数判空校验
        if (StringUtils.isEmpty(orderNo)) throw new QiHangException("20001", "必填参数异常！");
        // 查询订单状态
        Map<String, String> map = payLogService.queryOrderStatus(orderNo);
        if (Objects.isNull(map)) throw new QiHangException("20001","订单支付出错啦！");
        // TODO 获取订单状态（测试阶段，未支付订单将自动购买）
        if ("SUCCESS".equals(map.get("trade_state")) || "NOTPAY".equals(map.get("trade_state"))) {
            // 订单支付成功
            // 添加记录到支付表，更新订单表状态
            payLogService.updateOrderStatus(map);
            return R.success().message("订单支付成功！");
        }
        return R.failed().code("25000").message("订单支付中···");
    }

}

