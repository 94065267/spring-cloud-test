package com.jixs.ribbon;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * @author jixs
 * @date 2019/1/8
 */
@SpringBootApplication
public class FirstServerStrap2 {
    public static void main(String[] args){
        new SpringApplicationBuilder(FirstServerStrap2.class)
                .properties("server.port="+"8081").run(args);
    }
}
