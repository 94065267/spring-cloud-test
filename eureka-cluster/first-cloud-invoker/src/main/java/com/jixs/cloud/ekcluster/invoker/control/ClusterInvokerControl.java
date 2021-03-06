package com.jixs.cloud.ekcluster.invoker.control;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author jixs
 * @date 2019/1/3
 */
@Slf4j
@RestController
@Configuration
public class ClusterInvokerControl {

    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    @RequestMapping(value = "/router", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public String router() {
        log.warn("router进来了");
        RestTemplate restTpl = getRestTemplate();
        // 根据应用名称调用服务 cluster-providers -- 服务提供者应用名称
        return restTpl.getForObject("http://cluster-providers/person/10", String.class);
    }
}
