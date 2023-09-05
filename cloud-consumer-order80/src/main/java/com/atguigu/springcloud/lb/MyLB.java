package com.atguigu.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author Lin lin
 * ClassName: MyLB
 * Package: com.atguigu.lb
 * Date: 2023/8/29
 * Description:
 */
//自定义一个本地负载均衡器试试
@Component
public class MyLB implements LoadBalancer
{
    //atomicInteger初始值为0。
    private AtomicInteger atomicInteger = new AtomicInteger(0);

    public final int getAndIncrement()
    {
        int current;
        int next;
        //compareAndSet()方法来保证原子性更新值的操作，在多线程环境下能够正确地进行计数并保证线程安全。
        do
        {
            //首先获取当前的值，通过this.atomicInteger.get()方法获取。
            current = this.atomicInteger.get();
            //2147483647=Integer.MAX_VALUE
            next = current >= 2147483647 ? 0 : current + 1;
        } while(!this.atomicInteger.compareAndSet(current, next));
        //使用compareAndSet(current, next)方法尝试原子地将当前值替换为下一个值，
        // 如果替换成功，则退出循环；如果替换失败，则再次进行do的操作。
        System.out.println("*****next: "+next);
        return next;
    }


    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstances)
    {
        int index = getAndIncrement() % serviceInstances.size();
        return serviceInstances.get(index);
    }
}
