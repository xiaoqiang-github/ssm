package com.ywq.ssm.service;

import java.util.List;

import com.ywq.ssm.model.Dept;

public interface DeptService {
	public void insertDept(Dept dept);
	public List<Dept> selectDept();

}
