package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.lb.LoadBalance;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;


/**
 * @program: cloud2020
 * @description: 80 订单微服务消费者表现层
 * @author: Mr.Yang
 * @create: 2020-11-09 09:49
 **/
@RestController
@Slf4j
public class OrderController {

//    private static final String PAYMENT_URL = "http://localhost:8001";

    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Resource
    private LoadBalance loadBalancer;

    @Resource
    private RestTemplate restTemplate;
    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping("/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment) {
        log.info("80订单微服务消费者 ---- 消费成功");
        return restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, CommonResult.class);
    }

    @GetMapping("/consumer/payment/postForEntity/create")
    public CommonResult<Payment> create2(Payment payment) {
        log.info("80订单微服务消费者 ---- 消费成功");
        return restTemplate.postForEntity(PAYMENT_URL + "/payment/create" , payment ,CommonResult.class).getBody();
    }




    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id) {
                                                                     log.info("80订单微服务消费者 ---- 消费成功");
        return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
    }


    @GetMapping("/consumer/payment/getForEntity/{id}")
    public CommonResult<Payment> getPayment2(@PathVariable("id") Long id) {
        log.info("80订单微服务消费者 ---- 消费成功");
        ResponseEntity<CommonResult> forEntity = restTemplate.getForEntity(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
        if (forEntity.getStatusCode().is2xxSuccessful()) {
            log.info("我是响应状态码 " + forEntity.getStatusCode() + "\t" + "我是响应头部信息" + forEntity.getHeaders());
            return forEntity.getBody();
        } else {
            return new CommonResult<>(444, "操作失败");
        }
    }

    /**
     * 路由规则：轮询
     * @param
     * @return
     */
    @GetMapping(value = "/consumer/payment/lb")
    public String getPaymentLB(){
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        if(instances == null || instances.size() <= 0){
            return null;
        }
        ServiceInstance serviceInstance = loadBalancer.instances(instances);
        URI uri = serviceInstance.getUri();
        return restTemplate.getForObject(uri+"/payment/lb",String.class);
    }

}
