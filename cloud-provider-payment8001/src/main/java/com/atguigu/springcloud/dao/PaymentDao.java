package com.atguigu.springcloud.dao;


import com.atguigu.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


/**
 * @program: cloud2020
 * @description: 订单服务Dao层
 * @author: Mr.Yang
 * @create: 2020-11-03 11:29
 **/

@Mapper
public interface PaymentDao {

    /**
     * @author Mr.Yang
     * @date 2020/11/3 11:30
     * @Description:   订单创建
     * @param [payment]
     * @return int
     */
    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);
}
