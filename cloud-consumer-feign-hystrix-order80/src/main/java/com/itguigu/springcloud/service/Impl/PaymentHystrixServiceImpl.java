package com.itguigu.springcloud.service.Impl;

import com.itguigu.springcloud.service.PaymentHystrixService;
import org.springframework.stereotype.Component;

/**
 * @Author Lin lin
 * ClassName: PaymentHystrixServiceImpl
 * Package: com.itguigu.springcloud.service.Impl
 * Date: 2023/8/31
 * Description:
 */
@Component
public class PaymentHystrixServiceImpl  implements PaymentHystrixService {
    @Override
    public String paymentInfo_OK(Integer id) {
        return "PaymentHystrixServiceImpl----paymentInfo_OK";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "PaymentHystrixServiceImpl----paymentInfo_TimeOut";
    }
}
