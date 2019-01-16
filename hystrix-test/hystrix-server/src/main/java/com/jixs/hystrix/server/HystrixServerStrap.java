package com.jixs.hystrix.server;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * @author jixs
 * @date 2019/1/16
 */
@SpringBootApplication
public class HystrixServerStrap {
    public static void main(String[] args){
        new SpringApplicationBuilder(HystrixServerStrap.class).run(args);
    }
}
