package com.jixs.cloud.rest.server;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * rest服务启动类
 * @author jixs
 */
@SpringBootApplication
public class ServerStrap {

    public static void main(String[] args) {
        new SpringApplicationBuilder(ServerStrap.class).run(args);
    }
}
