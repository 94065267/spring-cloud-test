package com.jixs.ribbon;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * @author jixs
 * @date 2019/1/8
 */
@SpringBootApplication
public class FirstServerStrap1 {
    public static void main(String[] args) {
        new SpringApplicationBuilder(FirstServerStrap1.class)
                .properties("server.port=" + "8080").run(args);
    }
}
