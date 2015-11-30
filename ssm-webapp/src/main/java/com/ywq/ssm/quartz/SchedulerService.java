package com.ywq.ssm.quartz;

/**
 * 调度服务
 * @author yangWeiQiang
 *
 */
public interface SchedulerService {

	public void executeFirstTask();
	public void executeSecondTask();
}
