package com.springcloud.Service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.aspectj.weaver.Dump;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import javax.ws.rs.Path;
import java.util.concurrent.TimeUnit;

/**
 * @Author Lin lin
 * ClassName: PaymentService
 * Package: com.springcloud.Service
 * Date: 2023/8/30
 * Description:
 */
@Service
public class PaymentService {
    public String paymentInfo_OK(Integer id){

        int a = 10/0;
        return "线程池"+Thread.currentThread().getName()+"paymentInfo_OK,id:"+id;
    }

    //paymentInfo_TimeOut方法超时或者报错都会执行下哪个兜底的方法
//    fallbackMethod = "paymentInfo_TimeOut_Handler"超时或者出错误时候跳转执行此方法
    //@HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "3000")等待此方法3秒钟，3秒钟还没返回就调用兜底方法
    //调用http://localhost:8001/payment/timeout/1会执行paymentInfo_TimeOut_Handler方法
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOut_Handler",commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "3000")
    })
    public String paymentInfo_TimeOut(Integer id){
        int timeNumber = 100;//设置等待时间为5秒，5>3所以一定会超时，然后执行兜底方法
//        int a = 10/0;
        try{
            TimeUnit.SECONDS.sleep(timeNumber);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return "线程池："+Thread.currentThread().getName()+"paymentInfo_TimeOut,id:"+id;
    }

    //兜底方法
    public String paymentInfo_TimeOut_Handler(Integer id){
        return "线程池："+Thread.currentThread().getName()+"系统繁忙或者运行报错，请稍后再试一试，id:"+id;
    }

    //=========服务熔断,HystrixProperty的name的值来源于HystrixCommandProperties
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"), //至少访问十次才会触发服务熔断
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),//10秒以内
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"),//访问百分之60以上出错
    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){
        if(id<0){
            throw new RuntimeException("******id 不能负数");
        }
        String serialNumber = IdUtil.simpleUUID();
        return Thread.currentThread().getName()+"\t调用成功，流水号："+serialNumber;
    }

    public String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id){
        return "id不能负数，请稍后再试，/(TOT)/~~id:"+id;
    }


}
