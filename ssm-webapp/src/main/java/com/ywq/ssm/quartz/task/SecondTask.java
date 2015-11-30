package com.ywq.ssm.quartz.task;

import org.apache.log4j.Logger;


/**
 * 第二个任务
 * @author yangWeiQiang
 *
 */
public class SecondTask {

	private Logger log = Logger.getLogger(SecondTask.class);
	
	public void execute(){
		log.debug("-----执行第 2 个任务-----");
	}
}
