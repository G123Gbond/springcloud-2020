package com.itguigu.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @Author Lin lin
 * ClassName: PaymentController
 * Package: com.itguigu.springcloud.controller
 * Date: 2023/8/28
 * Description:
 */
@RestController
@Slf4j
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/payment/consul")
    public String consulTest(){
        return "Springcloud,port:"+serverPort+ UUID.randomUUID();
    }
}
