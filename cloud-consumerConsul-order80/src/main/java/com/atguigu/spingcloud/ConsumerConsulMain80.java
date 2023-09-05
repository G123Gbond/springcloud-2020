package com.atguigu.spingcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author Lin lin
 * ClassName: ConsumerConsulMain80
 * Package: atguigu.spingcloud
 * Date: 2023/8/29
 * Description:
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ConsumerConsulMain80 {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerConsulMain80.class,args);
    }
}
