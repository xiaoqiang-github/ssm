package com.ywq.ssm.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/mobile")
public class MobileContoller {

	private static final String MOBILE_URL = "http://webservice.webxml.com.cn/WebServices/MobileCodeWS.asmx";
	
	@RequestMapping(value="/queryInfo/{mobileCode}")
	public void queryMobileInfo(@PathVariable String mobileCode) throws Exception{
		HttpClient client = HttpClientBuilder.create().build();
		HttpPost post = new HttpPost(MOBILE_URL+"/getDatabaseInfo");
		
		//set params
		/*List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("mobileCode", mobileCode));
		params.add(new BasicNameValuePair("userId", ""));
		post.setEntity(new UrlEncodedFormEntity(params,"UTF-8"));
		*/
		HttpResponse response = client.execute(post);
		 HttpEntity entity = response.getEntity();
		 String result = EntityUtils.toString(entity);
		 
		 client.getConnectionManager().closeExpiredConnections();
		 System.err.println("返回结果："+result);
	}
}
