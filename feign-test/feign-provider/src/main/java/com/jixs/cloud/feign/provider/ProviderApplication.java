package com.jixs.cloud.feign.provider;

import java.util.Scanner;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ProviderApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(ProviderApplication.class)
				.properties("server.port=8080").run(args);
	}
}
