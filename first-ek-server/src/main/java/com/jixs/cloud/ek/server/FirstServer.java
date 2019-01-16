package com.jixs.cloud.ek.server;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author jixs
 * @date 2019/1/2
 */
@SpringBootApplication
@EnableEurekaServer
public class FirstServer {
    public static void main(String[] args) {
        new SpringApplicationBuilder(FirstServer.class).run(args);
    }
}
