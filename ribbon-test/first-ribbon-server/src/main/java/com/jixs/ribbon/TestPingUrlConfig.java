package com.jixs.ribbon;

import com.jixs.ribbon.ping.ServerPing;
import com.netflix.client.ClientFactory;
import com.netflix.config.ConfigurationManager;
import com.netflix.loadbalancer.Server;
import com.netflix.niws.client.http.RestClient;

import java.util.List;

/**
 * @author jixs
 * @date 2019/1/9
 */
public class TestPingUrlConfig {
    public static void main(String[] args) throws InterruptedException {
        // 设置请求的服务器
        ConfigurationManager.getConfigInstance()
                .setProperty("my-client.ribbon.listOfServers", "localhost:8080,localhost:8081");
        //配置ping处理类
//        ConfigurationManager.getConfigInstance()
//                .setProperty("my-client.ribbon.NFLoadBalancerPingClassName", PingUrl.class.getName());
        ConfigurationManager.getConfigInstance()
                .setProperty("my-client.ribbon.NFLoadBalancerPingClassName", ServerPing.class.getName());
        //配置ping处理时间间隔
        ConfigurationManager.getConfigInstance()
                .setProperty("my-client.ribbon.NFLoadBalancerPingInterval", 2);
        // 获取REST请求客户端
        RestClient client = (RestClient) ClientFactory.getNamedClient("my-client");
        Thread.sleep(6000);
        List<Server> servers = client.getLoadBalancer().getAllServers();
        System.out.println(servers.size());
        // 进行6次服务器选择
        for (Server server : servers) {
            System.out.println(server.getHostPort() + "状态：" + server.isAlive());
        }
    }
}
