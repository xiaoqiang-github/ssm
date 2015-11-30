package com.ywq.ssm.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.thoughtworks.xstream.XStream;
import com.ywq.ssm.model.weichat.TextMessage;

/**
 * XML转换类
 * @author yangWeiQiang
 *
 */
public class MessageUtil {

	/**
	 * 获取文本消息xml
	 * @param FromUserName 发送者
	 * @param ToUserName 接受者
	 * @param Content 内容
	 * @return xml
	 */
	public static String getTextMsgXml(String FromUserName,String ToUserName,String Content){
		TextMessage textMsg = new TextMessage();
		textMsg.setFromUserName(FromUserName);
		textMsg.setToUserName(ToUserName);
		textMsg.setContent(Content);
		textMsg.setCreateTime(System.currentTimeMillis());
		textMsg.setMsgType(MessageType.TEXT);
		
		return MessageUtil.textMsg2Xml(textMsg);
	}
	
	/**
	 * 将xml转为Map
	 * @param 输入流
	 * @return map
	 */
	public static Map<String,String> xml2Map(InputStream in){
		SAXReader reader  = new SAXReader();
		Map<String,String> map = new HashMap<String,String>();
		try {
			Document document = reader.read(in);
			Element root = document.getRootElement();
			List<Element> elements = root.elements();
			for(Element element : elements){
				map.put(element.getName(), element.getText());
			}
		} catch (DocumentException e) {
			e.printStackTrace();
		}finally{
			try {
				if(in != null){
					in.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return map;
	}
	
	/**
	 * XStream 将对象转为xml
	 * @param map
	 * @return
	 */
	public static String textMsg2Xml(TextMessage textMsg){
		XStream xstream = new XStream();
		xstream.alias("xml", textMsg.getClass());//将生成的根节点元素<com.ywq.ssm.model.weichat.TextMessage>替换为<xml>
		return xstream.toXML(textMsg);
	}
}
