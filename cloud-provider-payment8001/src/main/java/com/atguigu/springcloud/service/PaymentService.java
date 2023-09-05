package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @Author Lin lin
 * ClassName: PaymentService
 * Package: com.atguigu.springcloud.service
 * Date: 2023/8/25
 * Description:
 */
public interface PaymentService {
    int create(Payment payment);

    Payment getPaymentById(@Param("id") Long id);
}
