package com.silence.ch13.serviceloader.impl;

import com.silence.ch13.serviceloader.IService;

public class HelloService implements IService {

	@Override
	public String getScheme() {
		return "Hello";
	}

	@Override
	public String say() {
		return "Hello KK";
	}

}
