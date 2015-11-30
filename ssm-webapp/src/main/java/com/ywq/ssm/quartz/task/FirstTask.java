package com.ywq.ssm.quartz.task;

import org.apache.log4j.Logger;


/**
 * 第一个任务
 * @author yangWeiQiang
 *
 */
public class FirstTask {

	private Logger log = Logger.getLogger(FirstTask.class);
	
	public void execute(){
		log.debug("-----执行第 1 个任务-----");
	}
}
