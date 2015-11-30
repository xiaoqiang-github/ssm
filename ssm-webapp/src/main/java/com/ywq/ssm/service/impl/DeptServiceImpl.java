package com.ywq.ssm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ywq.ssm.mapper.DeptMapper;
import com.ywq.ssm.model.Dept;
import com.ywq.ssm.service.DeptService;

@Service(value="deptService")
public class DeptServiceImpl implements DeptService{

	@Resource(name="deptMapper")
	private DeptMapper deptMapper;
	
	@Override
	public void insertDept(Dept dept) {
		deptMapper.insertDept(dept);
	}

	@Override
	public List<Dept> selectDept() {
		return deptMapper.selectDept();
	}

	
}
