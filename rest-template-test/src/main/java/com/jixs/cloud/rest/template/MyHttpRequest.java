package com.jixs.cloud.rest.template;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpRequest;

import java.net.URI;

/**
 * 自定义的请求类，用于转换URI
 * @author jixs
 *
 */
public class MyHttpRequest implements HttpRequest {
	
	private HttpRequest sourceRequest;
	
	public MyHttpRequest(HttpRequest sourceRequest) {
		this.sourceRequest = sourceRequest;
	}

	@Override
	public HttpHeaders getHeaders() {
		return sourceRequest.getHeaders();
	}

	@Override
	public HttpMethod getMethod() {
		return sourceRequest.getMethod();
	}

	/**
	 * 将URI转换
	 */
	@Override
	public URI getURI() {
		try {
			URI newUri = new URI("http://localhost:8080/hello");
			return newUri;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sourceRequest.getURI();
	}
}
