package com.atguigu.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @program: cloud2020
 * @description: 所有类的配置类
 * @author: Mr.Yang
 * @create: 2020-11-09 09:57
 **/
@Configuration
public class ApplicationContextConfig {

    @Bean
//    @LoadBalanced   //使用LoadBalanced注解赋予restRempate负载均衡能力
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
// applicationContext.xml  <bean  id="" class="">