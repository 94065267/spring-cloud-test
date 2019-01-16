package com.jixs.cloud.feign.client.interceptor;

import com.jixs.cloud.feign.client.PersonClient;
import com.jixs.cloud.feign.client.PersonClientNoAnnotation;
import feign.Feign;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import feign.jaxrs.JAXRSContract;

/**
 * @author jixs
 * @date 2019/1/12
 */
public class Myinterceptor implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate requestTemplate) {
        requestTemplate.header("Content Type", "application/json");
    }

    public static void main(String[] args) {
        //获取服务接口
        PersonClientNoAnnotation personClient = Feign.builder()
                .requestInterceptor(new Myinterceptor())
                .target(PersonClientNoAnnotation.class, "http://localhost:8080/");
        String response = personClient.sayHello();
        System.out.println(response);
    }
}
