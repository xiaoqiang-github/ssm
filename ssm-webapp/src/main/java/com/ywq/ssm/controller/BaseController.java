package com.ywq.ssm.controller;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

public class BaseController {

	public void send(String str,HttpServletResponse response){
		OutputStream out = null;
		try {
			out = response.getOutputStream();
			//out.write(String.valueOf(str.getBytes("utf-8")));
			out.write(str.getBytes("UTF-8"));
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				if(out != null){
					out.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
