package com.jixs.ribbon.rule;

import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.Server;

import java.util.List;

/**
 * @author jixs
 * @date 2019/1/9
 */
public class ServerChooseRule implements IRule {
    ILoadBalancer loadBalancer;
    public ServerChooseRule(){

    }
    public ServerChooseRule(ILoadBalancer loadBalancer){
        this.loadBalancer = loadBalancer;
    }
    @Override
    public Server choose(Object o) {
        List<Server> servers = loadBalancer.getAllServers();
        return servers.get(0);
    }

    @Override
    public void setLoadBalancer(ILoadBalancer iLoadBalancer) {
        this.loadBalancer = iLoadBalancer;
    }

    @Override
    public ILoadBalancer getLoadBalancer() {
        return this.loadBalancer;
    }
}
