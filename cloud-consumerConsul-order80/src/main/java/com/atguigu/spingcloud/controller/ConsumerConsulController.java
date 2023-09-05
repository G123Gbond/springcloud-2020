package com.atguigu.spingcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Author Lin lin
 * ClassName: ConsumerConsulController
 * Package: com.atguigu.spingcloud.controller
 * Date: 2023/8/29
 * Description:
 */
@RestController
@Slf4j
public class ConsumerConsulController {

    public static final String INVOKE_URL = "http://consul-provider-payment";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/consul")
    public String getPaymentConsul(){
        return restTemplate.getForObject(INVOKE_URL+"/payment/consul",String.class);
    }


}
