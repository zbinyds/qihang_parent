package com.zbinyds.eduOrder.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zbinyds.R;
import com.zbinyds.eduOrder.client.EduClient;
import com.zbinyds.eduOrder.client.UcenterClient;
import com.zbinyds.eduOrder.mapper.OrderMapper;
import com.zbinyds.eduOrder.pojo.Order;
import com.zbinyds.eduOrder.service.OrderService;
import com.zbinyds.eduOrder.utils.OrderNoUtil;
import com.zbinyds.orderVo.CourseOrder;
import com.zbinyds.orderVo.MemberOrder;
import com.zbinyds.servicebase.exceptionHandler.QiHangException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * 订单 服务实现类
 * </p>
 *
 * @author zbinyds
 * @since 2022-09-29
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {

    @Autowired
    private EduClient eduClient; // 远程调用客户端

    @Autowired
    private UcenterClient ucenterClient; // 远程调用客户端

    @Override
    public String saveOrder(String courseId, String memberId) {
        /**
         * 一、远程调用service-edu微服务。通过用户id获取该用户基本信息
         */
        CourseOrder courseOrder = eduClient.getCourseOrder(courseId);
        if (Objects.isNull(courseOrder)) // 远程调用失败
            throw new QiHangException("20001","请求失败，接口异常！");
        /**
         * 二、远程调用service-ucenter微服务。通过课程id获取该课程基本信息
         */
        MemberOrder memberOrder = ucenterClient.getMemberOrder(memberId);
        if (Objects.isNull(memberOrder)) // 远程调用失败
            throw new QiHangException("20001","请求失败，接口异常！");
        /**
         * 三、封装订单对象。
         */
        Order order = new Order();
        order.setOrderNo(OrderNoUtil.getOrderNo()); // 订单号
        order.setCourseId(courseId); // 课程id
        order.setCourseTitle(courseOrder.getTitle()); // 课程名
        order.setCourseCover(courseOrder.getCover()); // 课程封面
        order.setTotalFee(courseOrder.getPrice()); // 课程价格
        order.setTeacherName(courseOrder.getTeacherId());
        order.setMemberId(memberId); // 会员id
        order.setNickname(memberOrder.getNickname()); // 会员昵称
        order.setMobile(memberOrder.getMobile()); // 会员手机号码
        order.setStatus(0);
        order.setPayType(1);
        /**
         * 四、添加订单并返回订单编号。
         */
        baseMapper.insert(order);
        return order.getOrderNo();
    }
}
