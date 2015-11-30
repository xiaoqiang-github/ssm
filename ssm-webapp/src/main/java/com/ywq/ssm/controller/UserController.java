package com.ywq.ssm.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ywq.ssm.model.User;
import com.ywq.ssm.service.UserService;

@Controller
@RequestMapping(value="/user")
public class UserController extends BaseController{
	
	private Logger log  = LoggerFactory.getLogger(this.getClass());
	
	@Resource(name="userService")
	private UserService userService;
	
	@RequestMapping(value="/init")
	public String initUser(){
		return "user/userIndex";
	}
	
	@RequestMapping(value="/userIdArr")
	public String userIdArr(@RequestParam("userIds[]") String[] userIds){
		
		return "user/userIndex";
	}
	@RequestMapping(value="/userList")
	public String userList(@RequestBody List<User> userList,HttpServletRequest request){
		System.out.println("objId="+request.getParameter("objId"));;
		return "user/userIndex";
	}
	
	
	@RequestMapping(value="/queryUsers")
	public ModelAndView queryUsers(){
		List<User> userList = userService.selectUserByParam(null);
		Map<String,Object> param = new HashMap<String, Object>();
		param.put("userList", userList);
		
		log.info("=====查询用户====");
		return new ModelAndView("user/userList",param);
	}
	
	@RequestMapping(value="/login")
	@ResponseBody
	public String login(User user,HttpServletRequest request,HttpServletResponse response){
		List<User> listUser = userService.selectUserByParam(user);
		Map<String,Object> returnMap = new HashMap<String,Object>();
		if(listUser!=null && listUser.size()==1){
			request.getSession().setAttribute("user", listUser.get(0));
			returnMap.put("flag", true);
		}else{
			returnMap.put("flag", false);
			returnMap.put("message", "Username Or Password invalid!");
		}
		JSONObject json = new JSONObject();
		json.putAll(returnMap);
		
		return json.toString();
	}
	
	@RequestMapping(value="/toLogin")
	public ModelAndView toLogin(HttpServletRequest request,HttpServletResponse response){
		
		return new ModelAndView("login");
	}
	
	
	@RequestMapping(value="/queryUser_obj")
	@ResponseBody
	public Map<String, Object> queryUser(){
		
		Map<String,Object> returnMap = new HashMap<String,Object>();
		returnMap.put("flag", true);
		returnMap.put("message", "json obj!");
		return returnMap;
	}
	
	@RequestMapping(value="/findUser_str")
	@ResponseBody
	public String findUser(){
		
		Map<String,Object> returnMap = new HashMap<String,Object>();
		returnMap.put("flag", true);
		returnMap.put("message", "json串儿 !");
		JSONObject json = new JSONObject();
		json.putAll(returnMap);
		return json.toString();
	}

	@RequestMapping(value="/getUser_response")
	public void getUser(HttpServletResponse response){
		
		Map<String,Object> returnMap = new HashMap<String,Object>();
		returnMap.put("flag", true);
		returnMap.put("message", "json response !");
		JSONObject json = new JSONObject();
		json.putAll(returnMap);
		
		this.send(json.toString(), response);
	}
	
	

}
