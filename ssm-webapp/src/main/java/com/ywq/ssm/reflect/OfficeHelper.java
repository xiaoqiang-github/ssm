package com.ywq.ssm.reflect;

public class OfficeHelper {

	/**
	 * 打开Office
	 * 这种方式的坏处：
	 * 如果Word、Excel类有1个不存在，则整个openOffice都不能用
	 * 理想状态是：
	 * 我传word是，给我打开Word，就算Excel不存在，也不能导致Word不能用
	 * 当我传入excel时,再告诉我Excel不存在
	 * 
	 * 改善:
	 * @see OfficeBetter
	 * @param type
	 */
	public static void openOffice(String type){
		if("word".equals(type)){
			new Word().start();
		}else if("excel".equals(type)){
			new Excel().start();
		}
	}
	
	public static void main(String[] args) {
		openOffice("word");
	}
}
