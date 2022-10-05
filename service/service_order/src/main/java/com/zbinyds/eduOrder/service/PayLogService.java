package com.zbinyds.eduOrder.service;

import com.zbinyds.eduOrder.pojo.PayLog;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * <p>
 * 支付日志表 服务类
 * </p>
 *
 * @author zbinyds
 * @since 2022-09-29
 */

public interface PayLogService extends IService<PayLog> {

    /**
     * 生成微信支付二维码
     * @param orderNo：订单编号
     * @return：返回二维码地址以及其他参数。
     */
    Map createNative(String orderNo);

    /**
     * 查询订单状态
     * @param orderNo：订单编号
     * @return：返回map，包含了订单支付的状态。SUCCESS表示支付成功
     */
    Map<String, String> queryOrderStatus(String orderNo);

    /**
     * 更新订单状态，并且向支付表中添加记录。
     * @param map
     */
    void updateOrderStatus(Map<String, String> map);
}
