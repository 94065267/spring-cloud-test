package com.jixs.cloud.ribbon.invoker.ping;

import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.Server;

/**
 * 服务提供检测实现
 *
 */
public class ProviderPing implements IPing {

    @Override
    public boolean isAlive(Server server) {
        System.out.println("自定义Ping类，服务器信息：" + server.getHostPort());
        return true;
    }
}
