package com.ywq.ssm.reflect;

public class Word implements Office{
	private String version;
	private Office office;
	
	public void start(){
		System.out.println("-----Word start-----");
	}
	
	public String version(String version,Integer type){
		System.out.println("-----Word 2013-----");
		return "";
	}

	public void getInfo(String name,String... msg){
		System.err.println(name);
		for(int i=0;i<msg.length;i++){
			System.out.println(msg[i]);
		}
	}
	
	
	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public Office getOffice() {
		return office;
	}

	public void setOffice(Office office) {
		this.office = office;
	}
}
