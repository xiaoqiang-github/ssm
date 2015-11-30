package com.ywq.ssm.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

import net.sf.json.JSONObject;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.XMLWriter;

import com.ywq.ssm.model.weichat.AccessToken;

/**
 * HTTP 工具类
 * @author yangWeiQiang
 *
 */
public class WeiChatUtils {
	
	
	
	//开发者ID
	public static final String AppID = "wx6267f87b1c00566b";
	public static final String AppSecret = "b4541628f645bc15b998696b8b9d1e5f";
	
	//微信相关接口
	public static final String ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token"+
											"?grant_type=client_credential"+
											"&appid="+ AppID + 
											"&secret=" + AppSecret;
	public static final String MENU_URL = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";
	
	/**
	 * 获取AccessToken
	 * @return
	 */
	public static AccessToken getAccessToken(){
		AccessToken token = new AccessToken();
		JSONObject jsonObject = sendGet(ACCESS_TOKEN_URL);
		if(jsonObject!=null){
			String access_token = jsonObject.getString("access_token");
			int expires_in = jsonObject.getInt("expires_in");
			
			//1.保存token到xml文件
			Document doc = DocumentHelper.createDocument();
			Element root =doc.addElement("xml");
			root.addElement("AccessToken").setText(access_token);
			root.addElement("ExpiresIn").setText(String.valueOf(expires_in));
			System.out.println(doc.asXML());
			OutputStream out;
			try {
				String path = WeiChatUtils.class.getResource("/").getPath();//获取WEB-INF/classes/路径
				System.out.println(path);
				File outFile = new File(path+"/AccessToken.xml");
				out = new FileOutputStream(outFile);
				XMLWriter writer = new XMLWriter(out);
				writer.write(doc);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			//2.封装token对象
			token.setAccess_token(access_token);
			token.setExpires_in(expires_in);
		}
		return token;
	}
	
	
	/**
	 * 获取HttpClient
	 * @return
	 */
	public static HttpClient getHttpClient(){
		return new DefaultHttpClient();
	}
	
	/**
	 * 发送get请求
	 * @param uri
	 * @return
	 */
	public static JSONObject sendGet(String uri){
		System.out.println("开始请求："+uri);
		HttpGet get = new HttpGet(uri);
		HttpClient client = getHttpClient();
		JSONObject jsonObject = null;
		try {
			HttpResponse response = client.execute(get);
			String result = EntityUtils.toString(response.getEntity(),"UTF-8");
			if(result!=null){
				jsonObject = jsonObject.fromObject(result);
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return jsonObject;
	}
	
	/**
	 * 发送post请求
	 * @param uri
	 * @param params
	 * @return
	 */
	public static JSONObject sendPost(String uri,String params){
		HttpPost post = new HttpPost(uri);
		HttpClient client = getHttpClient();
		JSONObject jsonObject = null;
		try {
			post.setEntity(new StringEntity(params, "utf-8"));
			HttpResponse response = client.execute(post);
			String result = EntityUtils.toString(response.getEntity(),"UTF-8");
			if(result!=null){
				jsonObject.fromObject(result);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		return jsonObject;
	}
}
