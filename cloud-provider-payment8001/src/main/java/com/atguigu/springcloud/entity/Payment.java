package com.atguigu.springcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: cloud2020
 * @description: 订单实体类
 * @author: Mr.Yang
 * @create: 2020-11-03 11:12
 **/
@Data
@AllArgsConstructor  //有参构造函数
@NoArgsConstructor    //无参构造函数
public class Payment {
    private Long id;
    private String  serial;
}
