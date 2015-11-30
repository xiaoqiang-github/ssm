package com.ywq.ssm.jms.listener;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * 消息监听类
 * @author yangWeiQiang
 *
 */
public class ConsumerMessageListener implements MessageListener {

	/**
	 * 当监听到消息时，会调用此方法
	 */
	@Override
	public void onMessage(Message msg){
		TextMessage textMsg = (TextMessage) msg;
		try {
			System.out.println("----消费者开始接收消息-----");
			System.out.println("----------------接收消息----"+textMsg.getText());
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

}
