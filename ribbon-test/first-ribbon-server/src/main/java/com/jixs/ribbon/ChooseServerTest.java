package com.jixs.ribbon;

import com.netflix.loadbalancer.BaseLoadBalancer;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jixs
 * @date 2019/1/9
 */
public class ChooseServerTest {
    public static void main(String[] args){
        ILoadBalancer baseLoadBalancer = new BaseLoadBalancer();
        List<Server> servers = new ArrayList<>();
        servers.add(new Server("localhost", 8080));
        servers.add(new Server("localhost", 8081));
        baseLoadBalancer.addServers(servers);
        // 进行6次服务器选择
        for(int i = 0; i < 6; i++) {
            Server s = baseLoadBalancer.chooseServer(null);
            System.out.println(s);
        }
    }
}
