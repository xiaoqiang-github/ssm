package com.ywq.ssm.designModel.factory;

import com.ywq.ssm.designModel.factory.model.AppleFruit;
import com.ywq.ssm.designModel.factory.model.Fruit;
import com.ywq.ssm.designModel.factory.model.LiFruit;

/**
 * 水果工厂
 * @author ywq
 *
 */
public class FruitFactory {

	/**
	 * 依据水果类型来生产水果
	 * 缺点：如果再新增一种水果，则需修改此方法再加一种类型判断
	 * @param type
	 * @return
	 */
	public static Fruit getFruit(String type){
		if(type == null){
			throw new IllegalArgumentException("参数为空!");
		}
		if("apple".equals(type)){
			return new AppleFruit();
		}
		if("li".equals(type)){
			return new LiFruit();
		}
		return null;
	}
	
	/**
	 * 依据 类名称 来成产水果
	 * @param className
	 * @return
	 */
	public static Fruit getFruitByClass(String className){
		try {
			Fruit fruit = (Fruit) Class.forName(className).newInstance();
			return fruit;
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
}
