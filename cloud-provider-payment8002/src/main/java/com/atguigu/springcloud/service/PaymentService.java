package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @program: cloud2020
 * @description: 订单业务层
 * @author: Mr.Yang
 * @create: 2020-11-03 11:34
 **/
public interface PaymentService  {
    /**
     * @author Mr.Yang
     * @date 2020/11/3 11:35
     * @Description:  创建订单
     * @param [payment]
     * @return int
     */
    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);

}
