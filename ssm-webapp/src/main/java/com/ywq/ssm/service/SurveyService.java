package com.ywq.ssm.service;

import java.util.Map;

import com.ywq.ssm.model.PageData;
import com.ywq.ssm.model.Survey;

public interface SurveyService {
	public PageData selectSurveyByCondition(Survey survey,PageData pageData) ;
	public Survey selectSurveyDetailById(String surveyId);
	public void insertSurvey(Survey survey);
	public Long countSurveyByCondition(Map<String,Object> param);
}
