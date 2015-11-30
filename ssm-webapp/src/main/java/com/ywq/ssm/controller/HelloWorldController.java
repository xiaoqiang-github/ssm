package com.ywq.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ywq.ssm.api.interfaces.HelloWorld;
import com.ywq.ssm.impl.HelloWorldImpl;

@Controller
@RequestMapping("/helloWorld")
public class HelloWorldController {

	@RequestMapping("/say/{worlds}")
	@ResponseBody
	public String say(@PathVariable("worlds") String worlds){
		HelloWorld hw = new HelloWorldImpl();
		return hw.sayHello(worlds);
	}
}
