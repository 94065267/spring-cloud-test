package com.jixs.cloud.feign.invoker.contract;

import feign.Contract;
import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {

    /**
     * 返回一个自定义的注解翻译器
     */
    @Bean
    public Contract feignContract() {
        return new MyContract();
    }

    @Bean
    public RequestInterceptor getRequestInterceptorsA() {
        return template -> System.out.println("这是第一个请求拦截器");
    }

    @Bean
    public RequestInterceptor getRequestInterceptorsB() {
        // FIXME: 2019/1/16
        return template -> System.out.println("这是第二个请求拦截器");
    }
}
