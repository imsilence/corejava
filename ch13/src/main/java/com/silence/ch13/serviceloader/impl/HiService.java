package com.silence.ch13.serviceloader.impl;

import com.silence.ch13.serviceloader.IService;

public class HiService implements IService {

	@Override
	public String getScheme() {
		return "Hi";
	}

	@Override
	public String say() {
		return "Hi KK";
	}

}
