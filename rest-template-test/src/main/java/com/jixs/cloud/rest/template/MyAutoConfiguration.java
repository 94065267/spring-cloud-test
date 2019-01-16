package com.jixs.cloud.rest.template;

import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 自动配置类
 *
 * @author jixs
 * @date 2019/1/11
 */
@Configuration
public class MyAutoConfiguration {

    @Autowired(required = false)
    @MyLoadBalanced
    private List<RestTemplate> myTemplates = Collections.emptyList();

    @Bean
    public SmartInitializingSingleton myLoadBalancedRestTemplateInitializer() {
        System.out.println("====  这个Bean将在容器初始化时创建    =====");
        return () -> {
            for (RestTemplate tpl : myTemplates) {
                // 创建一个自定义的拦截器实例
                MyInterceptor mi = new MyInterceptor();
                // 获取RestTemplate原来的拦截器
                List<ClientHttpRequestInterceptor> list = new ArrayList<>(tpl.getInterceptors());
                // 添加到拦截器集合
                list.add(mi);
                // 将新的拦截器集合设置到RestTemplate实例
                tpl.setInterceptors(list);
            }
        };
    }
}
