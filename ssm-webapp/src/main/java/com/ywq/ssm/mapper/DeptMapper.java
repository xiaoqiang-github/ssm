package com.ywq.ssm.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ywq.ssm.model.Dept;

@Repository(value="deptMapper")
public interface DeptMapper {
	public void insertDept(Dept dept);
	public List<Dept> selectDept();
}
