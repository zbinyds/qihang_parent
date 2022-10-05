package com.zbinyds.eduOrder.service;

import com.zbinyds.eduOrder.pojo.Order;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 订单 服务类
 * </p>
 *
 * @author zbinyds
 * @since 2022-09-29
 */
public interface OrderService extends IService<Order> {

    /**
     * 生成订单（远程调用service-edu、service-ucenter模块）
     * @param courseId：课程id
     * @param memberId：会员id
     * @return：返回生成的订单号。
     */
    String saveOrder(String courseId, String memberId);
}
