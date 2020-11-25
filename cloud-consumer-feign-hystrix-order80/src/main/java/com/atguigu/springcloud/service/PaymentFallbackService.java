package com.atguigu.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @program: cloud2020
 * @description:  服务降级统通配
 * @author: Mr.Yang
 * @create: 2020-11-17 17:22
 **/
@Component
public class PaymentFallbackService implements  PaymentHystrixService {


    @Override
    public String paymentInfo_ok(Integer id) {
        return "----PaymentFallbackService fall back-paymentInfo_OK,o(╥﹏╥)o11111111111";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "----PaymentFallbackService fall back-paymentInfo_TimeOut,o(╥﹏╥)o22222222";
    }
}