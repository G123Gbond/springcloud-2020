package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * @Author Lin lin
 * ClassName: PaymentController
 * Package: com.atguigu.springcloud.controller
 * Date: 2023/8/25
 * Description:
 */
@RestController
@Slf4j
@EnableDiscoveryClient
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverport;

    @Resource
    DiscoveryClient discoveryClient;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        log.info("插入数据****"+result);
        if(result>0){
            return new CommonResult<>(200,serverport+"插入数据成功",result);
        }
        return new CommonResult<>(444,serverport+"插入数据失败",null);
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id")Long id){
        Payment payment = paymentService.getPaymentById(id);
        log.info("查询结果*****"+payment+"\t"+id);
        if(Objects.nonNull(payment)){
            return new CommonResult<>(200,serverport+"查询成功",payment);
        }
        return new CommonResult<>(444,serverport+"没有对应记录,查询ID："+id,null);
    }

    @GetMapping(value = "/payment/discovery")
    public DiscoveryClient discovery(){
        //获取服务名
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("******service:"+service);
        }

        //获取payment的两个实例即8001和8002
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PROVIDER-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info(instance.getServiceId()+"\t"+instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri());
        }
        return this.discoveryClient;

    }

    @GetMapping(value = "/payment/lb")
    public String getPaymentLB(){
        return serverport;
    }

    @GetMapping(value = "/payment/feign/timeout")
    public String paymentFeignTimeout(){
        try {
            TimeUnit.SECONDS.sleep(3);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return serverport;
    }



}
