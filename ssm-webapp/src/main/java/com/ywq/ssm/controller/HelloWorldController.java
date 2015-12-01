package com.ywq.ssm.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ywq.ssm.api.interfaces.HelloService;

@Controller
@RequestMapping("/helloWorld")
public class HelloWorldController {

	@Resource(name="helloService")
	private HelloService helloService;
	
	@RequestMapping("/say/{worlds}")
	@ResponseBody
	public String say(@PathVariable("worlds") String worlds){
		return helloService.sayHello(worlds+"T__M___D");
	}
}
