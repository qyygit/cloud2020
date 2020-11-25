package com.atguigu.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;

/**
 * @program: cloud2020
 * @description: ribbon负载均衡定义类
 * @author: Mr.Yang
 * @create: 2020-11-16 11:55
 **/
public class MySelfRule {

    @Bean
    public IRule myRule(){
        return new RandomRule();
    }
}
