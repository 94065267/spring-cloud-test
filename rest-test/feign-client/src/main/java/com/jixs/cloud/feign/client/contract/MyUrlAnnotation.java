package com.jixs.cloud.feign.client.contract;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author jixs
 * @date 2019/1/12
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MyUrlAnnotation {
    String url();

    String method();

    public interface HelloClient {
        @MyUrlAnnotation(method = "GET", url = "hello")
        String myHello();
    }
}
