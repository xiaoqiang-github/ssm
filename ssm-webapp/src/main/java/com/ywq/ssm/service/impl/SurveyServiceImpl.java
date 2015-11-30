package com.ywq.ssm.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ywq.ssm.mapper.DeptMapper;
import com.ywq.ssm.mapper.SurveyMapper;
import com.ywq.ssm.model.PageData;
import com.ywq.ssm.model.Survey;
import com.ywq.ssm.service.SurveyService;

@Service(value="surveyService")
public class SurveyServiceImpl implements SurveyService{

	@Resource(name="surveyMapper")
	private SurveyMapper surveyMapper;
	
	@Resource(name="deptMapper")
	private DeptMapper detpMapper;
	
	public PageData selectSurveyByCondition(Survey survey,PageData pageData) {
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("survey", survey);
		param.put("page", pageData);
		pageData.setTotalCount(this.countSurveyByCondition(param).intValue());
		pageData.setData(surveyMapper.selectSurveyByCondition(param));
		return pageData;
	}

	public Survey selectSurveyDetailById(String surveyId) {
		return surveyMapper.selectSurveyDetailById(surveyId);
	}

	@Override
	public void insertSurvey(Survey survey) {
		surveyMapper.insertSurvey(survey);
	}

	@Override
	public Long countSurveyByCondition(Map<String, Object> param) {
		return surveyMapper.countSurveyByCondition(param);
	}

}
