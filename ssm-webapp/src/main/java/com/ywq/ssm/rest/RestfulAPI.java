package com.ywq.ssm.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.ywq.ssm.model.User;
/**
 * 解释各个注解的基本用法
 * @author yangWeiQiang
 */
public class RestfulAPI {

	//1. 接收哪种HTTP请求
	@GET
	@POST
	@PUT
	@DELETE
	
	//2. 访问资源路径及服务器响应内容
	@Path("/api")	//路径
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})//服务器返回json/xml格式的数据
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})//客户端需要发送json/xml格式的数据
	
	//3. 请求参数
	@PathParam("name")//结合@Path("/api/{name}")使用 ,
	@QueryParam("name")//从url中获取参数名称为name的值 。 适用于@GET
	@FormParam("name")//从url中获取参数名称为name的值 。 适用于@POST
	
	public String explain(User user){
		
		//返回user 格式依据@Produces
		Response.ok(user).build();
		return null;
	}
}
