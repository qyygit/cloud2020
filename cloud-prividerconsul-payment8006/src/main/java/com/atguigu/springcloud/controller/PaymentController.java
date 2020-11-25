package com.atguigu.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @program: cloud2020
 * @description: consul服务提供者
 * @author: Mr.Yang
 * @create: 2020-11-13 15:18
 **/
@RestController
@Slf4j
public class PaymentController {


    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "/payment/consul")
    public String paymentzk(){
        log.info("调用Consul服务成功");
        return "springcloud with Consul："+serverPort+"\t"+ UUID.randomUUID().toString();

    }
}

