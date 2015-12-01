package com.ywq.ssm.impl;

import com.ywq.ssm.api.interfaces.HelloService;

public class HelloServiceImpl implements HelloService{

	public String sayHello(String world) {
		return "您传入的参数为:"+world;
	}

}
