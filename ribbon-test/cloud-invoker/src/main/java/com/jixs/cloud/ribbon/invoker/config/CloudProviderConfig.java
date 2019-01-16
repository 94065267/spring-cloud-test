package com.jixs.cloud.ribbon.invoker.config;

import org.springframework.cloud.netflix.ribbon.RibbonClient;

@RibbonClient(name = "cloud-provider", configuration = MyConfig.class)
public class CloudProviderConfig {

}
