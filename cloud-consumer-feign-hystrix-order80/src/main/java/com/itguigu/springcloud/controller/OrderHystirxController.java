package com.itguigu.springcloud.controller;

import com.itguigu.springcloud.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author Lin lin
 * ClassName: OrderHystirxController
 * Package: com.itguigu.springcloud.controller
 * Date: 2023/8/30
 * Description:
 */
@RestController
@DefaultProperties(defaultFallback = "payment_Global_FallbackMethod")
public class OrderHystirxController {

    @Resource
    private PaymentHystrixService paymentHystrixService;

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id)
    {
        String result = paymentHystrixService.paymentInfo_OK(id);
        return result;
    }


//    @HystrixCommand(fallbackMethod = "paymentTimeOutFallbackMethod",commandProperties = {
//            @HystrixProperty(name= "execution.isolation.thread.timeoutInMilliseconds",
//                    value = "1500")
//})
    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
    @HystrixCommand
    //value是调用8001接口1.5秒不反回就执行paymentTimeOutFallbackMethod方法
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id)
    {
        int a = 10/0;
        String result = paymentHystrixService.paymentInfo_TimeOut(id);
        return result;
    }

    public String paymentTimeOutFallbackMethod(@PathVariable("id") Integer id)
    {
        return "我是消费者80，对方支付系统繁忙请10秒钟后再试或者自己运行出错请检查自己";
    }

    //全局处理方法
    //方法不能有参数，否则无法关联
    public String payment_Global_FallbackMethod()
    {
        return "我是消费者80，系统异常请待会再试.....";
    }


}
