package com.ywq.ssm.designModel.abstractFactory;

public class FactoryTest {
	public static void main(String[] args) {
		PersonFactory bigPerson = new BigPersonFactory();
		bigPerson.getBoy().draw();
		bigPerson.getGirl().draw();
	}
}
