package com.atguigu.springcloud;

import com.atguigu.rule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @Author Lin lin
 * ClassName: OrderMain80
 * Package: com.atguigu.springcloud
 * Date: 2023/8/23
 * Description:
 */
@SpringBootApplication
@EnableEurekaClient
//@RibbonClient(name = "cloud-provider-service",configuration = MySelfRule.class)//改为随即方式
public class OrderMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderMain80.class,args);
    }
}
