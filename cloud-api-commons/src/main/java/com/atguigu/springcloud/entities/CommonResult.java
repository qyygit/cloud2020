package com.atguigu.springcloud.entities;

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
public class CommonResult<T> {

    private Integer code;
    private String message;
    private T data;

    public CommonResult(Integer code ,String message){
        this(code,message,null);
    }

}
