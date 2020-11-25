package com.atgugui.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @program: cloud2020
 * @description:
 * @author: Mr.Yang
 * @create: 2020-11-12 16:47
 **/
@RestController
@Slf4j
public class PaymentController {


    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "/payment/zk")
    public String paymentzk(){
        log.info("调用zookeeper服务成功");
        return "springcloud with zookeeper："+serverPort+"\t"+ UUID.randomUUID().toString();

    }
}
