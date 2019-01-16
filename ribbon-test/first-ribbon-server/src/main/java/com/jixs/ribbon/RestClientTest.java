package com.jixs.ribbon;

import com.netflix.client.ClientFactory;
import com.netflix.client.http.HttpRequest;
import com.netflix.client.http.HttpResponse;
import com.netflix.config.ConfigurationManager;
import com.netflix.niws.client.http.RestClient;


/**
 * 通过配置指定服务选择规则测试
 *
 * @author jixs
 * @date 2019/1/8
 */
public class RestClientTest {
    public static void main(String[] args) throws Exception {
        // 设置请求的服务器
        ConfigurationManager.getConfigInstance().setProperty(
                "my-client.ribbon.listOfServers",
                "localhost:8080,localhost:8081");
        // 获取REST请求客户端
        RestClient client = (RestClient) ClientFactory
                .getNamedClient("my-client");
        // 创建请求实例
        HttpRequest request = HttpRequest.newBuilder().uri("/person/1").build();
        // 发 送10次请求到服务器中
        for (int i = 0; i < 6; i++) {
            HttpResponse response = client.executeWithLoadBalancer(request);
            String result = response.getEntity(String.class);
            System.out.println(result);
        }
    }
}
