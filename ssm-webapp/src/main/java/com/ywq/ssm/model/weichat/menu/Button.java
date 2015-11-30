package com.ywq.ssm.model.weichat.menu;

public class Button {
	private String name;
	private String type;
	
	private Button[] sub_button;//二级子菜单数组
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Button[] getSub_button() {
		return sub_button;
	}
	public void setSub_button(Button[] subButton) {
		sub_button = subButton;
	}
	
}
