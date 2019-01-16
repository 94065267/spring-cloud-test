package com.jixs.cloud.ribbon.provider;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class FirstServiceProvider2 {

    public static void main(String[] args) {
        // 设置启动的服务器端口
        new SpringApplicationBuilder(FirstServiceProvider.class)
                .properties("server.port=8081")
                .run(args);
    }
}
