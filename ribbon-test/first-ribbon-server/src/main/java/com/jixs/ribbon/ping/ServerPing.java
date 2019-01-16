package com.jixs.ribbon.ping;

import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.Server;

/**
 * @author jixs
 * @date 2019/1/9
 */
public class ServerPing implements IPing {
    @Override
    public boolean isAlive(Server server) {
        System.out.println("这是自定义的ping类："+server.getHostPort());
        return true;
    }
}
