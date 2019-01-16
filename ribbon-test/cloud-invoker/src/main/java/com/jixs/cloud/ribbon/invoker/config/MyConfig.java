package com.jixs.cloud.ribbon.invoker.config;

import com.jixs.cloud.ribbon.invoker.ping.ProviderPing;
import com.jixs.cloud.ribbon.invoker.rule.ProviderChooseRule;
import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;

/**
 * 指定获取服务和检测服务状态
 */
public class MyConfig {
    @Bean
    public IRule getRule() {
        return new ProviderChooseRule();
    }

    @Bean
    public IPing getPing() {
        return new ProviderPing();
    }
}
