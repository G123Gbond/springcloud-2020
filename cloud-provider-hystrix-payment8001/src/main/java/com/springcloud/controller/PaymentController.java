package com.springcloud.controller;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import com.springcloud.Service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author Lin lin
 * ClassName: PaymentController
 * Package: com.springcloud.controller
 * Date: 2023/8/30
 * Description:
 */
@RestController
@Slf4j
public class PaymentController {

    @Resource
    PaymentService paymentService;

    @GetMapping(value = "payment/ok/{id}")
    public String methodOk(@PathVariable("id") Integer id){
        String s = paymentService.paymentInfo_OK(id);
        log.info("ok的结果是:"+s);
        return s;
    }

    @GetMapping(value = "payment/timeout/{id}")
    public String methodTimeOut(@PathVariable("id") Integer id){
        String s = paymentService.paymentInfo_TimeOut(id);
        log.info("timeout的结果是:"+s);
        return s;
    }

    @GetMapping("/payment/circuit/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Integer id)
    {
        String result = paymentService.paymentCircuitBreaker(id);
        log.info("****result: "+result);
        return result;
    }



}
