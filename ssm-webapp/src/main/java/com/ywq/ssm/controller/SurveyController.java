package com.ywq.ssm.controller;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ywq.ssm.model.PageData;
import com.ywq.ssm.model.Survey;
import com.ywq.ssm.service.SurveyService;
import com.ywq.ssm.utils.UUIDGenerator;

@Controller
@RequestMapping(value="/survey")
public class SurveyController extends BaseController{

	@Resource(name="surveyService")
	private SurveyService surveyService;
	
	
	@RequestMapping(value="/selectSurveys")
	public ModelAndView selectSurverys(Survey survey){
		System.err.println("____"+survey);
		PageData pageData = new PageData(0,10,1);
		
		pageData =  surveyService.selectSurveyByCondition(survey,pageData);
		Map<String,Object> returnMap = new HashMap<String,Object>();
		returnMap.put("pageData", pageData);
		return new ModelAndView("survey/surveyList",returnMap);
	}
	
	@RequestMapping(value="/ajaxQuery")
	@ResponseBody
	public String ajaxQuerySurvey(String surveyName,PageData pageData,HttpServletRequest request) throws Exception{
		Survey survey = new Survey();
		survey.setSurveyName(surveyName);
		pageData =  surveyService.selectSurveyByCondition(survey,pageData);
		
		JSONObject json = JSONObject.fromObject(pageData);
		return json.toString();
	}
	
	@RequestMapping(value="/surveyAdd")
	public void addSurvery(Survey survey,HttpServletRequest request,HttpServletResponse response){
		survey.setSurveyId(UUIDGenerator.generateUUID());
		surveyService.insertSurvey(survey);
		
		this.send("xx",response);
	}
	
	@RequestMapping(value="/getSurvey/{surveyId}")
	public ModelAndView getSurveyById(@PathVariable String surveyId,HttpServletRequest request,HttpServletResponse response){
		Survey survey = surveyService.selectSurveyDetailById(surveyId);
		Map<String,Object> returnMap = new HashMap<String, Object>();
		returnMap.put("survey", survey);
		return new ModelAndView("survey/surveyAdd",returnMap);
	}
}
