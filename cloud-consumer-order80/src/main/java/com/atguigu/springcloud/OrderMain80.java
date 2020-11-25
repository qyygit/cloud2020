package com.atguigu.springcloud;

import com.atguigu.myrule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @program: cloud2020
 * @description: 80微服务订单消费者
 * @author: Mr.Yang
 * @create: 2020-11-09 09:28
 **/
@SpringBootApplication
@EnableEurekaClient
//80访问支付微服务CLOUD-PAYMENT-SERVICE, 不走默认轮询,走MySelfRule.class自己定义的
//@RibbonClient(name = "CLOUD-PAYMENT-SERVICE" , configuration = MySelfRule.class)
public class OrderMain80 {

    public static void main(String[] args) {
        SpringApplication.run(OrderMain80.class,args);
        System.out.println("80 -- 微服务订单消费者启动成功 ");
    }
}
