package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @program: cloud2020
 * @description: 订单服务主启动类
 * @author: Mr.Yang
 * @create: 2020-11-03 11:05
 **/
@SpringBootApplication
public class PaymentMain8001 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8001.class,args);
        System.out.println("8001订单服务器启动成功");
    }
}