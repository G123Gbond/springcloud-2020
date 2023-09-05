package com.itguigu.springcloud.service;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * @Author Lin lin
 * ClassName: OrderService
 * Package: com.itguigu.springcloud.service
 * Date: 2023/8/29
 * Description:
 */
@Component
@FeignClient(value = "cloud-provider-service")
public interface OrderFeignService {

    @GetMapping(value = "/payment/get/{id}")//对应8001或者8002的getPaymentById请求地址
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);

    @GetMapping(value = "/payment/feign/timeout")
    public String paymentFeignTimeout();

}
