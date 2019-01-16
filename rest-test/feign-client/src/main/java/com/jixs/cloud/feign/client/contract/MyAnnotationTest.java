package com.jixs.cloud.feign.client.contract;

import feign.Feign;

/**
 * @author jixs
 * @date 2019/1/12
 */
public class MyAnnotationTest {
    public static void main(String[] args) {
        MyUrlAnnotation.HelloClient helloClient = Feign.builder()
                .contract(new MyContract())
                .target(MyUrlAnnotation.HelloClient.class, "http://localhost:8080/");
        //请求Hello World 接口
        String result = helloClient.myHello();
        System.out.println("接口响应内容：" + result);
    }
}
