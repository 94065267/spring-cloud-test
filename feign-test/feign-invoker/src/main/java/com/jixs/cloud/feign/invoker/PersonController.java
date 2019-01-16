package com.jixs.cloud.feign.invoker;

public class PersonController implements PersonClient {

	@Override
	public String hello() {
		return null;
	}

	@Override
	public Person getPerson(Integer personId) {
		return null;
	}

}
