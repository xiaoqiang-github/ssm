package com.ywq.ssm.designModel.factory;

import com.ywq.ssm.designModel.factory.model.Fruit;
import com.ywq.ssm.designModel.factory.model.LiFruit;

public class FactoryTest {

	public static void main(String[] args) {
		//依据【水果类型】来得到水果
		Fruit fruit = FruitFactory.getFruit("li");
		fruit.eat();
		
		//依据 【类名称】
		Fruit f = FruitFactory.getFruitByClass(LiFruit.class.getName());
		f.eat();
	}

}
