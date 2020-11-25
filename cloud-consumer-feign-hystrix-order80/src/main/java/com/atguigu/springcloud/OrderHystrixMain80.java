package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @program: cloud2020
 * @description: Hystrix  消费者主启动类
 * @author: Mr.Yang
 * @create: 2020-11-17 10:45
 **/

@SpringBootApplication
@EnableFeignClients
@EnableCircuitBreaker
public class OrderHystrixMain80 {

    public static void main(String[] args) {
        SpringApplication.run(OrderHystrixMain80.class,args);
        System.out.println("80 Hystrix 服务降级,熔断,限流 服务消费者启动成功");
    }
}
