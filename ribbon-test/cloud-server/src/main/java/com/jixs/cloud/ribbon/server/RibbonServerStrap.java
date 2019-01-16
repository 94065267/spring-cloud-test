package com.jixs.cloud.ribbon.server;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author jixs
 * @date 2019/1/9
 */
@SpringBootApplication
@EnableEurekaServer
public class RibbonServerStrap {
    public static void main(String[] args){
        new SpringApplicationBuilder(RibbonServerStrap.class).run(args);
    }
}
