package com.ywq.ssm.reflect;

import java.lang.reflect.Method;

public class OfficeBetter {
	
	/**
	 * 
	 * @param className
	 */
	public static void openOffice(Object obj){
		try {
			Class c = obj.getClass();
			Office office = (Office) c.newInstance();
			office.start();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		openOffice(new Word());
	}
}
