package com.jixs.cloud.feign.invoker.contract;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 客户端接口
 * @author jixs
 *
 */
@FeignClient(name = "feign-provider")
public interface HelloClient {
	
	@MyUrl(method = "GET", url = "/hello")
	String myHello();
	
	@RequestMapping(method = RequestMethod.GET, value = "/hello")
	String springHello();
}
