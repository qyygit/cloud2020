package com.atguigu.springclooud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @program: cloud2020
 * @description:
 * @author: Mr.Yang
 * @create: 2020-11-17 19:41
 **/

@SpringBootApplication
@EnableHystrixDashboard
public class HystrixDashboardMain9001 {

    public static void main(String[] args) {
        SpringApplication.run(HystrixDashboardMain9001.class,args);
        System.out.println("HystrixDashboard 图形化服务器启动");
    }
}
