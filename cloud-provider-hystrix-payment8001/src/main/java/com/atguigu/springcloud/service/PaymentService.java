package com.atguigu.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * @program: cloud2020
 * @description:
 * @author: Mr.Yang
 * @create: 2020-11-17 10:03
 **/
@Service
public class PaymentService {

    /**
     * @author Mr.Yang
     * @date 2020/11/17 10:07
     * @Description:  正常访问
     * @param [id]
     * @return java.lang.String
     */
    public  String paymentInfo_ok(Integer id){
        return  "线程池 :  " + Thread.currentThread().getName() + "paymentInfo_ok ,id  " + id +  "\t" +  "O(∩_∩)O哈哈~";
    }


    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler",commandProperties = {
            //设置这个线程的超时时间是3s，3s内是正常的业务逻辑，超过3s调用fallbackMethod指定的方法进行处理
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "5000")
    })
    public String paymentInfo_Timeout(Integer id){
//        int timeNumber = 5;
//        int age = 10/0;
        try{
            TimeUnit.MILLISECONDS.sleep(3000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return "线程池："+Thread.currentThread().getName()+"   paymentInfo_Timeout,id："+id+"\t"+"O(∩_∩)O哈哈~"+"   耗时(秒)：3";
    }


    public String paymentInfo_TimeOutHandler(Integer id){
        return "线程池："+Thread.currentThread().getName()+"   8001服务端提供者系统繁忙或者运行报错，请稍后再试,id："+id+"\t"+"o(╥﹏╥)o";
    }


    //服务熔断
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),   //是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),  //请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),    //时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"),    //失败率达到多少后跳闸
    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){
        if(id < 0){
            throw new RuntimeException("******id 不能为负数");
        }
        String serialNumber = IdUtil.simpleUUID();  //UUID.randomUUID();

        return Thread.currentThread().getName()+"\t"+"调用成功，流水号："+serialNumber;
    }
    public String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id){
        return "id 不能负数，请稍后再试，o(╥﹏╥)o  id："+id;
    }
}
