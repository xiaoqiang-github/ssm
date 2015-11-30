package com.ywq.ssm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ywq.ssm.mapper.UserMapper;
import com.ywq.ssm.model.User;
import com.ywq.ssm.service.UserService;
import com.ywq.ssm.utils.UUIDGenerator;

@Service(value="userService")
public class UserServiceImpl implements UserService{

	@Resource(name="userMapper")
	private UserMapper userMapper;
	
	public List<User> selectUserByParam(User user) {
		return userMapper.selectUserByParam(user);
	}

	public List<User> selectUserDept() {
		return userMapper.selectUserDept();
	}

	@Override
	public User selectUserById(String id) {
		return userMapper.selectUserById(id);
	}

	public boolean insertUser(User user){
		user.setUserId(UUIDGenerator.generateUUID());
		userMapper.insertUser(user);
		return true;
	}
}
