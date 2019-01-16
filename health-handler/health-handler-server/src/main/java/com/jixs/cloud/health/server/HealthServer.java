package com.jixs.cloud.health.server;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author jixs
 * server启动类
 */
@SpringBootApplication
@EnableEurekaServer
public class HealthServer {
    public static void main(String[] args) {
        new SpringApplicationBuilder(HealthServer.class).run(args);
    }
}
