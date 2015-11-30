package com.ywq.ssm.utils;

import net.sf.json.JSONObject;

import com.ywq.ssm.model.weichat.AccessToken;
import com.ywq.ssm.model.weichat.menu.Button;
import com.ywq.ssm.model.weichat.menu.ClickButton;
import com.ywq.ssm.model.weichat.menu.Menu;

public class MenuUtil {

	
	public static void main(String[] args) {
		//获取accessToken
		AccessToken accessToken = WeiChatUtils.getAccessToken();
		String access_token = accessToken.getAccess_token();
		
		//获取 menu对象
		JSONObject jsonObj = JSONObject.fromObject(initMenu());
		String url = WeiChatUtils.MENU_URL.replace("ACCESS_TOKEN", access_token);
		
		//发动post请求
		JSONObject returnJson = WeiChatUtils.sendPost(url, jsonObj.toString());
		if(returnJson!=null){
			int retcode = returnJson.getInt("errcode");
			if(retcode==0){
				System.out.println("创建菜单成功!");
			}else {
				System.out.println("创建菜单失败!错误代码："+retcode);
			}
		}else{
			System.out.println("访问接口失败！！");
		}
	}
	
	public static Menu initMenu(){
		Menu menu  = new Menu();
		
		//1级菜单1
		ClickButton menu1 = new ClickButton();
		menu1.setName("扫码");
		
		//2级菜单01
		ClickButton menu11 = new ClickButton();
		menu11.setName("扫码带提示");
		menu11.setType("scancode_waitmsg");
		menu11.setKey("rselfmenu_0_0");
		
		//2级菜单02
		ClickButton menu12 = new ClickButton();
		menu12.setName("扫码推事件");
		menu12.setType("scancode_push");
		menu12.setKey("rselfmenu_0_1");
		
		menu1.setSub_button(new Button[]{menu11,menu12});
		
		
		//1级菜单2
		ClickButton menu2 = new ClickButton();
		menu2.setName("发图");
		
		//2级菜单21
		ClickButton menu21 = new ClickButton();
		menu21.setName("系统拍照发图");
		menu21.setType("pic_sysphoto");
		menu21.setKey("rselfmenu_1_0");
		
		//2级菜单22
		ClickButton menu22 = new ClickButton();
		menu22.setName("拍照或者相册发图");
		menu22.setType("pic_photo_or_album");
		menu22.setKey("rselfmenu_1_1");
		
		//2级菜单23
		ClickButton menu23 = new ClickButton();
		menu23.setName("微信相册发图");
		menu23.setType("pic_weixin");
		menu23.setKey("rselfmenu_1_2");
		
		menu2.setSub_button(new Button[]{menu21,menu22,menu23});
		
		//1级菜单3
		ClickButton menu3 = new ClickButton();
		menu3.setName("发送位置");
		menu3.setType("location_select");
		menu3.setKey("rselfmenu_2_0");
		
		
		//3个一级菜单组装到Menu对象中
		menu.setButton(new Button[]{menu1,menu2,menu3});
		
		return menu;
	}
}
