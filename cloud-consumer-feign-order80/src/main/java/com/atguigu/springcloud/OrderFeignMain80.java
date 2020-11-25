package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @program: cloud2020
 * @description: Feign消费者启动类
 * @author: Mr.Yang
 * @create: 2020-11-16 18:44
 **/
@SpringBootApplication
@EnableFeignClients
public class OrderFeignMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderFeignMain80.class,args);
        System.out.println("80-Feign-消费者启动成功");

    }
}
