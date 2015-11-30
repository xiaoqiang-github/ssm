package com.ywq.ssm.utils;

import java.util.UUID;

public class UUIDGenerator {

	public static synchronized String generateUUID(){
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
	
	public static void main(String[] args) {
		
		System.out.println("111111");
		
	}
}
