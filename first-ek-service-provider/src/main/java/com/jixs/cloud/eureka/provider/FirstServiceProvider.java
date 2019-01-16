package com.jixs.cloud.eureka.provider;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author jixs
 * @date 2019/1/3
 */
@SpringBootApplication
@EnableEurekaClient
public class FirstServiceProvider {
    public static void main(String[] args) {
        new SpringApplicationBuilder(FirstServiceProvider.class).run(args);
    }
}
