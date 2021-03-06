package com.jixs.cloud.ekcluster.provider;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import java.util.Scanner;

/**
 * @author jixs
 * @date 2019/1/3
 */
@SpringBootApplication
@EnableEurekaClient
public class ClusterProvider1 {
    public static void main(String[] args) {
        new SpringApplicationBuilder(ClusterProvider1.class)
                .properties("server.port=8090").run(args);
    }
}
