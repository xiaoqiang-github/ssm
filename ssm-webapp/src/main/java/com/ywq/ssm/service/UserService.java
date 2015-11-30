package com.ywq.ssm.service;

import java.util.List;

import com.ywq.ssm.model.User;

public interface UserService {
	public List<User> selectUserByParam(User user);
	public List<User> selectUserDept();
	
	public User selectUserById(String id);
	public boolean insertUser(User user);
}
