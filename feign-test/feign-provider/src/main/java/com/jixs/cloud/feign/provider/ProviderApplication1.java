package com.jixs.cloud.feign.provider;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ProviderApplication1 {

	public static void main(String[] args) {
		new SpringApplicationBuilder(ProviderApplication1.class)
				.properties("server.port=8081").run(args);
	}
}
