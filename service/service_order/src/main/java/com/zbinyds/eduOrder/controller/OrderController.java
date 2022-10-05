package com.zbinyds.eduOrder.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.zbinyds.JwtUtils;
import com.zbinyds.R;
import com.zbinyds.eduOrder.pojo.Order;
import com.zbinyds.eduOrder.service.OrderService;
import com.zbinyds.servicebase.exceptionHandler.QiHangException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

/**
 * <p>
 * 订单 前端控制器
 * </p>
 *
 * @author zbinyds
 * @since 2022-09-29
 */
@Api(tags = "订单接口管理")
@RestController
@RequestMapping("/eduOrder/order")
//@CrossOrigin
public class OrderController {

    @Autowired
    private OrderService orderService;

    @ApiOperation("生成订单")
    @PostMapping("/createOrder/{courseId}")
    public R saveOrder(@PathVariable String courseId, HttpServletRequest request) {
        // 必填参数校验
        if (StringUtils.isEmpty(courseId)) throw new QiHangException("20001", "必填参数异常！");
        // 通过token获取到登录用户id
        String memberId = JwtUtils.getMemberIdByJwtToken(request);
        if (StringUtils.isEmpty(memberId)) throw new QiHangException("20001", "请先登录！");
        // 生成订单并返回订单号
        String orderNo = orderService.saveOrder(courseId, memberId);
        return R.success().data("orderNo", orderNo);
    }

    @ApiOperation("根据订单id查询订单信息")
    @GetMapping("/getOrderDetail/{orderNo}")
    public R getOrderDetail(@PathVariable String orderNo) {
        // 必填参数校验
        if (StringUtils.isEmpty(orderNo)) throw new QiHangException("20001", "必填参数异常！");
        // 构建查询条件
        LambdaQueryWrapper<Order> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Order::getOrderNo, orderNo);
        Order order = orderService.getOne(queryWrapper);
        return !Objects.isNull(order) ? R.success().message("请求成功！").data("order", order) : R.failed().message("查询订单信息失败！");
    }

    @ApiOperation("付费课程是否被购买")
    @PostMapping("/isBuyCourse/{courseId}/{memberId}")
    public Boolean isBuyCourse(@PathVariable String courseId, @PathVariable String memberId) {
        LambdaQueryWrapper<Order> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Order::getStatus,1);
        queryWrapper.eq(Order::getCourseId,courseId);
        queryWrapper.eq(Order::getMemberId,memberId);
        int count = orderService.count(queryWrapper);
        return count > 0;
    }
}

