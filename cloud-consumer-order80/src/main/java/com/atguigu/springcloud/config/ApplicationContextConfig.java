package com.atguigu.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author Lin lin
 * ClassName: ApplicationContextConfig
 * Package: com.atguigu.springcloud.config
 * Date: 2023/8/23
 * Description:
 */
@Configuration
public class ApplicationContextConfig {
    //通过RestTempalte调用payment8001的东西，微服务之间的调用
    @Bean
//    @LoadBalanced//Ribbon的负载均衡
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
