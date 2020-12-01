package com.atguigu.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: cloud2020
 * @description:
 * @author: Mr.Yang
 * @create: 2020-12-01 15:17
 **/
@RestController
public class ConfigClientController {

    @Value("${config.info}")
    private String configInfo;  //要访问的3344上的信息

    @GetMapping("/configInfo")
    public String getConfigInfo(){
        return configInfo;
    }
}
