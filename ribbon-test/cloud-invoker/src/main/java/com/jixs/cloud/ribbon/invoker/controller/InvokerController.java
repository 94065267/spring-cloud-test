package com.jixs.cloud.ribbon.invoker.controller;

import com.netflix.loadbalancer.ZoneAwareLoadBalancer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.netflix.ribbon.SpringClientFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Configuration
public class InvokerController {
    @Autowired
    private LoadBalancerClient loadBalancer;
    @Autowired
    private SpringClientFactory factory;

    @LoadBalanced
    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    @RequestMapping(value = "/router", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String router() {
        RestTemplate restTpl = getRestTemplate();
        // 根据名称调用服务
        return restTpl.getForObject("http://cloud-provider/person/1", String.class);
    }

    @RequestMapping(value = "/uselb", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ServiceInstance uselb() {
        // 查找服务器实例
        ServiceInstance si = loadBalancer.choose("cloud-provider");
        return si;
    }

    @RequestMapping(value = "/defaultValue", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String defaultValue() {
        System.out.println("==== 输出默认配置：");
        // 获取默认的配置
        ZoneAwareLoadBalancer alb = (ZoneAwareLoadBalancer) factory.getLoadBalancer("default");
        System.out.println("    IClientConfig: " + factory.getLoadBalancer("default").getClass().getName());
        System.out.println("    IRule: " + alb.getRule().getClass().getName());
        System.out.println("    IPing: " + alb.getPing().getClass().getName());
        System.out.println("    ServerList: " + alb.getServerListImpl().getClass().getName());
        System.out.println("    ServerListFilter: " + alb.getFilter().getClass().getName());
        System.out.println("    ILoadBalancer: " + alb.getClass().getName());
        System.out.println("    PingInterval: " + alb.getPingInterval());
        System.out.println("==== 输出 cloud-provider 配置：");
        // 获取 cloud-provider 的配置
        ZoneAwareLoadBalancer alb2 = (ZoneAwareLoadBalancer) factory.getLoadBalancer("cloud-provider");
        System.out.println("    IClientConfig: " + factory.getLoadBalancer("cloud-provider").getClass().getName());
        System.out.println("    IRule: " + alb2.getRule().getClass().getName());
        System.out.println("    IPing: " + alb2.getPing().getClass().getName());
        System.out.println("    ServerList: " + alb2.getServerListImpl().getClass().getName());
        System.out.println("    ServerListFilter: " + alb2.getFilter().getClass().getName());
        System.out.println("    ILoadBalancer: " + alb2.getClass().getName());
        System.out.println("    PingInterval: " + alb2.getPingInterval());
        return "";
    }

}
