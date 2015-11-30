package com.ywq.ssm.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Properties文件工具类
 * @author ywq
 *
 */
public class PropertiesUtils {
	private static Map<String,String> propMap = new HashMap<String,String>();
	
	/**
	 * 依据key得到value
	 * @param key
	 * @return
	 */
	public static String getProValue(String key){
		Properties properties = new Properties();
		InputStream inStream = null;
		try {
			//For non-static method, use this :
			//	prop.load(getClass().getClassLoader().getResourceAsStream("config.properties"));
			inStream = PropertiesUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
			if(inStream == null ){
				System.out.println("----cannot to find "+"jdbc.properties");
				return null;
			}
			properties.load(inStream);
			
			return properties.getProperty(key);
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				if(inStream!=null){
					inStream.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return null;
	}
	
	/**
	 * 加载文件
	 */
	private static void load(){
		Properties properties = new Properties();
		InputStream inStream = null;
		try {
			//For non-static method, use this :
			//	prop.load(getClass().getClassLoader().getResourceAsStream("config.properties"));
			inStream = PropertiesUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
			if(inStream == null ){
				System.out.println("----cannot to find "+"jdbc.properties");
				return;
			}
			properties.load(inStream);
			
			Enumeration<?> elements = properties.propertyNames();
			while(elements.hasMoreElements()){
				String key = (String) elements.nextElement();
				String value = properties.getProperty(key);
				propMap.put(key,value);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				if(inStream!=null){
					inStream.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	/**
	 * 打印出propertie的内容
	 */
	public static void printAll(){
		load();
		for(String key : propMap.keySet()){
			System.err.println("key="+key+",value="+propMap.get(key));
		}
	}
}
