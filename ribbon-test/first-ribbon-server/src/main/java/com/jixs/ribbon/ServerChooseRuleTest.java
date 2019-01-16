package com.jixs.ribbon;

import com.jixs.ribbon.rule.ServerChooseRule;
import com.netflix.loadbalancer.BaseLoadBalancer;
import com.netflix.loadbalancer.RetryRule;
import com.netflix.loadbalancer.RoundRobinRule;
import com.netflix.loadbalancer.Server;

import java.util.ArrayList;
import java.util.List;

/**
 * 代码指定请求服务选择规则测试
 *
 * @author jixs
 * @date 2019/1/9
 */
public class ServerChooseRuleTest {
    public static void main(String[] args) {
        BaseLoadBalancer baseLoadBalancer = new BaseLoadBalancer();
        baseLoadBalancer.setRule(new ServerChooseRule(baseLoadBalancer));
        List<Server> servers = new ArrayList<>();
        servers.add(new Server("localhost", 8080));
        servers.add(new Server("localhost", 8081));
        baseLoadBalancer.addServers(servers);
        // 进行6次服务器选择
        for (int i = 0; i < 6; i++) {
            Server s = baseLoadBalancer.chooseServer(null);
            System.out.println(s);
        }
    }
}
