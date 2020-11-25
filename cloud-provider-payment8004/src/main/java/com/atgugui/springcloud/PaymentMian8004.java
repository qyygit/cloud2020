package com.atgugui.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @program: cloud2020
 * @description: 订单支付微服务启动类
 * @author: Mr.Yang
 * @create: 2020-11-12 16:38
 **/
@SpringBootApplication
@EnableDiscoveryClient  //该注解用于想使用consul或者zookeeper作为注册中心时注册服务
public class PaymentMian8004 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMian8004.class,args);
        System.out.println("8004订单微服务提供者启动成功");
    }
}
