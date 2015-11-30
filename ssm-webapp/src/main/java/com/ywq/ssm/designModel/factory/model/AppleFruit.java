package com.ywq.ssm.designModel.factory.model;


/**
 * 苹果
 * @author ywq
 *
 */
public class AppleFruit implements Fruit {

	@Override
	public void eat() {
		System.out.println("------我是苹果，我可以吃---");
	}

}
