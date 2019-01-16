package com.jixs.cloud.ekcluster.invoker;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author jixs
 * @date 2019/1/5
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ClusterInvoker {
    public static void main(String[] args) {
        new SpringApplicationBuilder(ClusterInvoker.class).run(args);
    }
}
