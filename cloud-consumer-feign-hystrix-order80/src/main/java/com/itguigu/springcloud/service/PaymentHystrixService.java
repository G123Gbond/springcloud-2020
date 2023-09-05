package com.itguigu.springcloud.service;

import com.itguigu.springcloud.service.Impl.PaymentHystrixServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author Lin lin
 * ClassName: PaymentHystrixService
 * Package: com.itguigu.springcloud.service
 * Date: 2023/8/30
 * Description:
 */
//fallback = PaymentHystrixServiceImpl.class用实现类给该类的每个方法加上服务降级
    //当方法调用报错、超时、宕机时，就会调用实现类的降级方法
@Component
@FeignClient(value = "cloud-provider-hystrix-payment",fallback = PaymentHystrixServiceImpl.class)
public interface PaymentHystrixService {

    @GetMapping("/payment/ok/{id}")
    String paymentInfo_OK(@PathVariable("id") Integer id);

    @GetMapping("payment/timeout/{id}")
    String paymentInfo_TimeOut(@PathVariable("id") Integer id);

}
