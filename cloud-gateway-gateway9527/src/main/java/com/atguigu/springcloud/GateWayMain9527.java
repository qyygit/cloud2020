package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;

/**
 * @program: cloud2020
 * @description:
 * @author: Mr.Yang
 * @create: 2020-11-18 15:21
 **/
@SpringBootApplication
@EnableCircuitBreaker
public class GateWayMain9527 {

    public static void main(String[] args) {
        SpringApplication.run(GateWayMain9527.class,args);
        System.out.println("9527 gateWay 网关服务器启动成功");
    }
}
