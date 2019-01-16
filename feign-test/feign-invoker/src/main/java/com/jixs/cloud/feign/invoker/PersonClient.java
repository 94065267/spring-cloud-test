package com.jixs.cloud.feign.invoker;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//声明调用的服务名称
@FeignClient("feign-provider")
public interface PersonClient {
	
	@RequestMapping(method = RequestMethod.GET, value = "/hello")
	String hello();

	@RequestMapping(method = RequestMethod.GET, value = "/person/{personId}")
	Person getPerson(@PathVariable("personId") Integer personId);
	

}
