package com.ywq.ssm.jms;

import javax.jms.Destination;

public interface MyMessage {

	public void sendMessage(Destination destination,final String msg);
}
