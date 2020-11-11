package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


/**
 * @program: cloud2020
 * @description: 订单实现层
 * @author: Mr.Yang
 * @create: 2020-11-03 18:28
 **/
@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @PostMapping(value = "/payment/create")
    public CommonResult Create(@RequestBody Payment payment){
       int result =  paymentService.create(payment);
        log.info("***************c插入成功********结果是  : "  + result);
        if (result>0){
            return  new CommonResult(200,"插入数据库成功",result);
        }else {
            return  new CommonResult(444,"插入数据库失败",null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        Payment payment =  paymentService.getPaymentById(id);
        System.out.println("测试");
        log.info("***************查询结果  : "  + payment);
        if (payment!=null){
            return  new CommonResult(200,"查询数据库成功",payment);
        }else {
            return  new CommonResult(444,"没有对应记录 查询ID : " + id,null);
        }
    }
}
