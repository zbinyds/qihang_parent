package com.zbinyds.eduOrder.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.wxpay.sdk.WXPayUtil;
import com.zbinyds.eduOrder.mapper.PayLogMapper;
import com.zbinyds.eduOrder.pojo.Order;
import com.zbinyds.eduOrder.pojo.PayLog;
import com.zbinyds.eduOrder.service.OrderService;
import com.zbinyds.eduOrder.service.PayLogService;
import com.zbinyds.eduOrder.utils.HttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 支付日志表 服务实现类
 * </p>
 *
 * @author zbinyds
 * @since 2022-09-29
 */
@Service
public class PayLogServiceImpl extends ServiceImpl<PayLogMapper, PayLog> implements PayLogService {

    @Autowired
    private OrderService orderService;

    @Override
    public Map createNative(String orderNo) {
        try {
            /**
             * 一、设置支付所需要的参数信息，封装到map中。
             */
            // 通过订单编号，获取订单信息。（支付参数需要）
            LambdaQueryWrapper<Order> queryWrapper = new LambdaQueryWrapper<>();
            queryWrapper.eq(Order::getOrderNo, orderNo);
            Order order = orderService.getOne(queryWrapper);

            HashMap paramsMap = new HashMap();
            paramsMap.put("appid", "wx74862e0dfcf69954"); // 微信开发者appId
            paramsMap.put("mch_id", "1558950191"); // 商户号
            paramsMap.put("nonce_str", WXPayUtil.generateNonceStr());
            paramsMap.put("body", order.getCourseTitle()); // 二维码的名称-课程名
            paramsMap.put("out_trade_no", orderNo); // 二维码唯一标识-订单号
            paramsMap.put("total_fee", order.getTotalFee().multiply(new BigDecimal("100")).longValue() + "");
            paramsMap.put("spbill_create_ip", "127.0.0.1");
            paramsMap.put("notify_url", "http://guli.shop/api/order/weixinPay/weixinNotify\n");
            paramsMap.put("trade_type", "NATIVE"); // 支付类型

            /**
             * 二、通过HTTPClient发送请求，请求携带参数信息map。
             */
            HttpClient client = new HttpClient("https://api.mch.weixin.qq.com/pay/unifiedorder");
            // 请求携带参数map。key为商户秘钥，用于请求加密。
            client.setXmlParam(WXPayUtil.generateSignedXml(paramsMap, "T6m9iK73b0kn9g5v426MKfHQH7X8rKwb"));
            client.setHttps(true);
            client.post();

            /**
             * 三、获取返回的数据（xml格式）。
             */
            String contentXml = client.getContent(); // xml格式
            Map<String, String> resultMap = WXPayUtil.xmlToMap(contentXml); // xml -> map

            /**
             * 四、返回数据的最终封装。
             */
            Map map = new HashMap<>();
            map.put("out_trade_no", orderNo);
            map.put("course_id", order.getCourseId());
            map.put("total_fee", order.getTotalFee()); // 金额
            map.put("result_code", resultMap.get("result_code")); // 请求状态
            map.put("code_url", resultMap.get("code_url")); // 二维码地址

            return map;
        } catch (Exception e) {
            return new HashMap<>(); // 返回空map，表示接口异常。
        }
    }

    @Override
    public Map<String, String> queryOrderStatus(String orderNo) {
        try {
            //1、封装参数
            Map m = new HashMap<>();
            m.put("appid", "wx74862e0dfcf69954"); // 微信开发者appId
            m.put("mch_id", "1558950191"); // 商户id
            m.put("out_trade_no", orderNo); // 订单号
            m.put("nonce_str", WXPayUtil.generateNonceStr());

            //2、设置请求
            HttpClient client = new HttpClient("https://api.mch.weixin.qq.com/pay/orderquery");
            // 请求携带参数map。key为商户秘钥，用于请求加密。
            client.setXmlParam(WXPayUtil.generateSignedXml(m, "T6m9iK73b0kn9g5v426MKfHQH7X8rKwb"));
            client.setHttps(true);
            client.post();

            //3、返回第三方的数据
            String xml = client.getContent();
            Map<String, String> resultMap = WXPayUtil.xmlToMap(xml);

            //4、返回
            return resultMap;
        } catch (Exception e) {
            return null;
        }
    }

    @Transactional // 多表操作，开启事务管理
    public void updateOrderStatus(Map<String, String> map) {
        /**
         * 一、支付成功后，更改订单表状态
         */
        String orderNo = map.get("out_trade_no"); // 订单编号
        // 根据订单编号查询订单信息
        LambdaQueryWrapper<Order> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Order::getOrderNo,orderNo);
        Order order = orderService.getOne(queryWrapper);
        if (order.getStatus() == 1) return; // 如果订单状态已经为已支付，那么直接返回。
        // 修改订单状态为已支付
        order.setStatus(1);
        orderService.update(order,queryWrapper);

        /**
         * 二、向支付表中添加一条记录
         */
        PayLog pay = new PayLog();
        pay.setOrderNo(orderNo); // 订单号
        pay.setPayTime(new Date()); // 订单完成时间
        pay.setPayType(1); // 支付方式
        pay.setTotalFee(order.getTotalFee()); // 订单金额
//        pay.setTradeState(map.get("trade_state")); // 支付状态
        pay.setTradeState("SUCCESS"); // TODO 测试阶段订单状态设置为成功
        pay.setTransactionId(map.get("transaction_id")); // 订单流水号
        pay.setAttr(JSONObject.toJSONString(map)); // 扫描二维码返回的map数据
        this.save(pay);
    }
}
