package com.itguigu.springcloud.configration;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author Lin lin
 * ClassName: FeignConfig
 * Package: com.itguigu.springcloud.configration
 * Date: 2023/8/29
 * Description:
 */
@Configuration
public class FeignConfig
{
    @Bean
    Logger.Level feignLoggerLevel()
    {
        return Logger.Level.FULL;
    }
}
