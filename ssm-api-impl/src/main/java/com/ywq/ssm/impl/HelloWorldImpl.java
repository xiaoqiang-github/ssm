package com.ywq.ssm.impl;

import com.ywq.ssm.api.interfaces.HelloWorld;

public class HelloWorldImpl implements HelloWorld{

	public String sayHello(String world) {
		return "您传入的参数为:"+world;
	}

}
