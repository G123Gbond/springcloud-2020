package com.itguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author Lin lin
 * ClassName: OrderMain80
 * Package: com.itguigu.springcloud
 * Date: 2023/8/29
 * Description:
 */
//凡是springcloud的组件都需要在主启动类激活，定义使用一份注解，激活使用一份注解
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients//激活openFeign
public class OrderMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderMain80.class,args);
    }
}
