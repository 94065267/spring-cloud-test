package com.jixs.cloud.feign.client;

import feign.Headers;
import feign.Param;
import feign.RequestLine;

/**
 * Person客户端服务类
 *
 * @author jixs
 */
public interface PersonClientNoAnnotation {
    @RequestLine("GET /hello")
    String sayHello();
}
