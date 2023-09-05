package com.atguigu.rule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Author Lin lin
 * ClassName: MySelfRule
 * Package: com.atguigu.rule
 * Date: 2023/8/29
 * Description:
 */
/*
Ribbon默认是轮询方式，现在改为随机方式
新建一个包,因为@SpringBootApplication底层用了@ComponentScan组件,
@SpringBootApplication会扫描它所在位置的直属包，此处为springcloud包,
这个自定义配置类不能放在@ComponentScan所扫描的当前包下以及子包下，
否则我们自定义的这个配置类就会被所有的Ribbon客户端所共享，达不到特殊化定制的目的了。*/
@Configuration
public class MySelfRule {
    @Bean
    public IRule myRule(){
        return new RandomRule();
    }
}
