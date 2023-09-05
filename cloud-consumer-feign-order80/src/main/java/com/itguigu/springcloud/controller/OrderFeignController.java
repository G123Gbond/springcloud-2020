package com.itguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.itguigu.springcloud.service.OrderFeignService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.weaver.ast.Or;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @Author Lin lin
 * ClassName: OrderFeignController
 * Package: com.itguigu.springcloud.controller
 * Date: 2023/8/29
 * Description:
 */
@RestController
@Slf4j
public class OrderFeignController {
    @Resource
    private OrderFeignService orderFeignService;

    @GetMapping("/consumer/payment/getPaymentById/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        return orderFeignService.getPaymentById(id);
    }

    //OpenFeign默认等待1秒钟，超过后报错
    //服务方8001故意写等待3秒，所以consumer调用时侯报等待超时错误
    //provider自己调用此接口是可以的，consumer不可以
    @GetMapping(value = "/consumer/payment/feign/timeout")
    public String paymentFeignTimeout(){
       return orderFeignService.paymentFeignTimeout();
    }
}
