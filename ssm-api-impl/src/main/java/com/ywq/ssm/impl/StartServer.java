package com.ywq.ssm.impl;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StartServer {

	/** 
	 * 加载Spring配置，启动服务
	 * @author YangWeiQiang
	 * @throws Exception 
	 * @date 2015-12-1 
	 */
	public static void main(String[] args) throws Exception {
		ClassPathXmlApplicationContext context = 
			new ClassPathXmlApplicationContext(new String[]{"dubbo-beans.xml"});
		context.start();
		
		System.in.read();
	}

}
