package com.jixs.ribbon;

import com.jixs.ribbon.rule.ServerChooseRule;
import com.netflix.loadbalancer.BaseLoadBalancer;
import com.netflix.loadbalancer.PingUrl;
import com.netflix.loadbalancer.Server;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jixs
 * @date 2019/1/9
 */
public class TestPingUrl {
    public static void main(String[] args) throws InterruptedException {
        BaseLoadBalancer baseLoadBalancer = new BaseLoadBalancer();
        baseLoadBalancer.setRule(new ServerChooseRule(baseLoadBalancer));
        List<Server> servers = new ArrayList<>();
        servers.add(new Server("localhost", 8080));
        servers.add(new Server("localhost", 8082));
        baseLoadBalancer.addServers(servers);
        baseLoadBalancer.setPing(new PingUrl());
        //ping时间间隔设置为2s
        baseLoadBalancer.setPingInterval(2);
        Thread.sleep(6000);

        // 进行6次服务器选择
        for (Server server : baseLoadBalancer.getAllServers()) {
            System.out.println(server.getHostPort() + "状态：" + server.isAlive());
        }
    }
}
