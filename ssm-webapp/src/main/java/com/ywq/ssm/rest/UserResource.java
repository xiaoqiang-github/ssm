package com.ywq.ssm.rest;

import java.util.List;

import javax.annotation.Resource;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.ywq.ssm.model.User;
import com.ywq.ssm.service.UserService;

@Path("/user")
@Produces({MediaType.APPLICATION_JSON})
public class UserResource {

	@Resource(name="userService")
	private UserService userService;
	
	@GET
	public List<User> getAllUser(){
		return userService.selectUserByParam(null);
	}
	
	@GET
	@Path("/{userId}")
	public User getUser(@PathParam(value = "userId") String id){
		return userService.selectUserById(id);
	}
	
	@POST
	@Consumes({MediaType.APPLICATION_JSON})
	public Response addUser(User user){
		if(user.getUserName().length()>32){
			return Response.ok("{\"retCode\":102,\"message\":\"名字不能超过32.\"}").build();
		}
		boolean flag = userService.insertUser(user);
		return Response.ok(user).build();
	}
	
	
	
}
