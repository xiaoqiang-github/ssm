package com.ywq.ssm.mapper;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.ywq.ssm.model.Survey;

@Repository(value="surveyMapper")
public interface SurveyMapper {
	public List<Survey> selectSurveyByCondition(Map<String,Object> param);
	public Survey selectSurveyDetailById(String surveyId);
	public void insertSurvey(Survey survey);
	public void initData();
	public Long countSurveyByCondition(Map<String,Object> param);
}
