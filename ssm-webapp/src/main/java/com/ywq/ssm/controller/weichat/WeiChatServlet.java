package com.ywq.ssm.controller.weichat;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ywq.ssm.utils.CheckUtils;
import com.ywq.ssm.utils.MessageType;
import com.ywq.ssm.utils.MessageUtil;
import com.ywq.ssm.utils.WeiChatUtils;

public class WeiChatServlet extends HttpServlet {
	private static final String TOKEN = "ssm_weichat_token";
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		String signature = request.getParameter("signature");
		String timestamp = request.getParameter("timestamp");
		String nonce = request.getParameter("nonce");
		String echostr = request.getParameter("echostr");
		
		boolean flag = CheckUtils.checkSignature(signature, TOKEN, timestamp, nonce);
		if(flag){
			try {
				PrintWriter writer = response.getWriter();
				writer.write(echostr);
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//防止乱码
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		Map<String,String> msgMap = MessageUtil.xml2Map(request.getInputStream());
		
		//接收到的消息
		Iterator<Entry<String, String>> ir = msgMap.entrySet().iterator();
		while(ir.hasNext()){
			Entry<String,String> entry = ir.next();
			System.out.println(entry.getKey()+"="+entry.getValue());
		}
		
		//消息类型
		String msgType = msgMap.get("MsgType");
		String FromUserName = msgMap.get("FromUserName");
		String ToUserName = msgMap.get("ToUserName");
		
		//回复消息
		String returnMsg = "";
		if(MessageType.TEXT.equals(msgType)){
			//文本消息
			String Content = msgMap.get("Content");
			
			String replyMsg = "";
			if(Content.contains("傻逼")||Content.endsWith("sb")||Content.toLowerCase().endsWith("shabi")){
				replyMsg = "你才是傻逼类!";
			}else {
				replyMsg = "您发送的信息为: \n"+Content;
			}
			returnMsg = MessageUtil.getTextMsgXml(ToUserName, FromUserName, replyMsg);
		}else if(MessageType.EVENT.equals(msgType)){
			//事件类型
			String eventType = msgMap.get("Event");
			if(MessageType.SUBSCRIBE.equals(eventType)){
				//关注
				String replayMsg = "感谢关注【我的朋友】！";
				returnMsg = MessageUtil.getTextMsgXml(ToUserName, FromUserName, replayMsg);
			}else if(MessageType.UNSUBSCRIBE.equals(eventType)){
				//取消关注
				String replayMsg = "靠！别啊亲！！！！";
				returnMsg = MessageUtil.getTextMsgXml(ToUserName, FromUserName, replayMsg);
			}
		}
		//System.out.println(returnMsg);
		
		//获取 AccessToken
		//System.err.println(WeiChatUtils.getAccessToken());;
		
		//回复消息
		PrintWriter writer = response.getWriter();
		writer.write(returnMsg);
		writer.close();
	}

}
