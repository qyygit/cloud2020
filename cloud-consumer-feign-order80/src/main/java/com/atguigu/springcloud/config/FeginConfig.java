package com.atguigu.springcloud.config;

import feign.Feign;
import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: cloud2020
 * @description: Feign 日志级别配置
 * @author: Mr.Yang
 * @create: 2020-11-16 19:37
 **/
@Configuration
public class FeginConfig {

    @Bean
    Logger.Level feignLogger(){
        return Logger.Level.FULL;
    }
}
