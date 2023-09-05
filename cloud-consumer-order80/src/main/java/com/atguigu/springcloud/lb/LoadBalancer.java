package com.atguigu.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import javax.xml.ws.Service;
import java.util.List;

/**
 * @Author Lin lin
 * ClassName: LoadBalance
 * Package: com.atguigu.lb
 * Date: 2023/8/29
 * Description:
 */
public interface LoadBalancer
{
    ServiceInstance instances(List<ServiceInstance> serviceInstances);
}
