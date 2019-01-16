package com.jixs.cloud.invoker;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author jixs
 * @date 2019/1/3
 */
@SpringBootApplication
@EnableDiscoveryClient
public class FirstInvoker {
    public static void main(String[] args) {
        new SpringApplicationBuilder(FirstInvoker.class).run(args);
    }
}
