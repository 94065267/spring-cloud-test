package com.jixs.cloud.env;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author jixs
 * @date 2019/1/2
 */
@Slf4j
@SpringBootApplication
public class MyApplication {
    public static void main(String[] args) {
        log.debug("系统启动。。。。。。");
        SpringApplication.run(MyApplication.class, args);
    }
}
