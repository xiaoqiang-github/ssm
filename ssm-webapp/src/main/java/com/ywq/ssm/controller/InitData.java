package com.ywq.ssm.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ywq.ssm.mapper.DeptMapper;
import com.ywq.ssm.mapper.SurveyMapper;
import com.ywq.ssm.model.Dept;
import com.ywq.ssm.model.Survey;
import com.ywq.ssm.service.DeptService;
import com.ywq.ssm.service.SurveyService;
import com.ywq.ssm.utils.UUIDGenerator;

@Controller
@RequestMapping(value="init")
public class InitData {

	@Resource(name="surveyService")
	private SurveyService surveyService;
	@Resource(name="deptService")
	private DeptService deptService;
	
	@RequestMapping(value="init")
	public void initData(){
		System.out.println("________start to init data......._______");
		//surveyService.initData();
	}
	
	@RequestMapping(value="testAop")
	public void testAop(){
		Survey s = new Survey();
		s.setSurveyId(UUIDGenerator.generateUUID());
		s.setSurveyName("测试一下");
		s.setMemo("备注");
		surveyService.insertSurvey(s);
		
		Dept d = new Dept();
		d.setDeptId(UUIDGenerator.generateUUID());
		d.setDeptName("测试部门");
		deptService.insertDept(d);

		int a = 1/0;
		
	}
}
