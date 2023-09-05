package com.itguigu.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.stereotype.Component;

/**
 * @Author Lin lin
 * ClassName: GateWayConfig
 * Package: com.atguigu.springcloud.config
 * Date: 2023/8/31
 * Description:
 */
@Configuration
public class GateWayConfig {

/*
    *配置了一个id为route-name的路由规则,
    *当访问地址http://Localhost:9527/politics/时会自动转发到地址: http://www.news.cn/politics/
*/
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder){
        RouteLocatorBuilder.Builder routes = builder.routes();
        routes.route("path_route_atguigu", r -> r.path("/politics").uri("http://www.news.cn/politics")).build();
        return routes.build();

    }
}
