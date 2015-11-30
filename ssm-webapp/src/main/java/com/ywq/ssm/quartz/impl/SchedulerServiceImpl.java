package com.ywq.ssm.quartz.impl;

import com.ywq.ssm.quartz.SchedulerService;
import com.ywq.ssm.quartz.task.FirstTask;
import com.ywq.ssm.quartz.task.SecondTask;

/**
 * @author yangWeiQiang
 *
 */
public class SchedulerServiceImpl implements SchedulerService{

	private FirstTask firstTask;
	private SecondTask secondTask;
	
	public void executeFirstTask() {
		firstTask.execute();
	}
	
	public void executeSecondTask() {
		secondTask.execute();
	}
	
	
	/**getter and setter***/
	public FirstTask getFirstTask() {
		return firstTask;
	}
	public void setFirstTask(FirstTask firstTask) {
		this.firstTask = firstTask;
	}
	public SecondTask getSecondTask() {
		return secondTask;
	}
	public void setSecondTask(SecondTask secondTask) {
		this.secondTask = secondTask;
	}
	
}
