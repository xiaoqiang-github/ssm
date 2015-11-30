package com.ywq.ssm.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ywq.ssm.model.User;

@Repository(value="userMapper")
public interface UserMapper {

	public List<User> selectUserByParam(User user);
	
	public List<User> selectUserDept();
	
	public User selectUserById(String id);
	
	public void insertUser(User user);
}
