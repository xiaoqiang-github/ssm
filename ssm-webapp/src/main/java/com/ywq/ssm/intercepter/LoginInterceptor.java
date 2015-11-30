package com.ywq.ssm.intercepter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.xml.resolver.apps.resolver;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.ywq.ssm.model.User;


public class LoginInterceptor implements  HandlerInterceptor{

	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object object, Exception exception)
			throws Exception {
		
	}

	public void postHandle(HttpServletRequest request, HttpServletResponse response,
			Object object, ModelAndView arg3) throws Exception {
		
	}

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object object) throws Exception {
		User loginUser = (User) request.getSession().getAttribute("user");
		if(loginUser!=null){
			return true;
		}else{
			String loginPath = request.getContextPath()+"/login.jsp";
			response.sendRedirect(loginPath);
			return true;
		}
	}

}
