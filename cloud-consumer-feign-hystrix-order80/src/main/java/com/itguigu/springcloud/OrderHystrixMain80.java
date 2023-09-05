package com.itguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author Lin lin
 * ClassName: OrderHystrixMain80
 * Package: com.itguigu.springcloud
 * Date: 2023/8/30
 * Description:
 */
@SpringBootApplication
@EnableFeignClients
@EnableHystrix//消费者开启Hystrix
public class OrderHystrixMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderHystrixMain80.class,args);
    }
}
