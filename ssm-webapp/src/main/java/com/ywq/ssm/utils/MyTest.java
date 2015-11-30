package com.ywq.ssm.utils;

import java.io.InputStream;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

public class MyTest {

	public static void main(String[] args) {
		getImg();
	}
	
	public static void getImg(){
		String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential"+
					 "&appid=wx8de27b1169532b5c&secret=87fc059ad94b95e17a893857efc07252";
		System.out.println(WeiChatUtils.sendGet(url));
		/*HttpClient httpClient = null;
		HttpGet method = null;
		try {
			httpClient = new DefaultHttpClient();
			method = new HttpGet("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=wx8de27b1169532b5c&secret=87fc059ad94b95e17a893857efc07252");
			HttpResponse response = httpClient.execute(method);
			String result =EntityUtils.toString( response.getEntity());
		} catch (Exception e) {
			e.printStackTrace();
		} */
	}
}
