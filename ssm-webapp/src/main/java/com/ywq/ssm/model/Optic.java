package com.ywq.ssm.model;

import java.math.BigDecimal;
import java.util.List;

public class Optic {
	private String opticId;
	private String opticName;
	private Integer opticIndex;
	private BigDecimal opticWeight;
	private BigDecimal score;
	
	private Survey survey;
	private List<Option> optionList;
	public String getOpticId() {
		return opticId;
	}
	public void setOpticId(String opticId) {
		this.opticId = opticId;
	}
	public String getOpticName() {
		return opticName;
	}
	public void setOpticName(String opticName) {
		this.opticName = opticName;
	}
	public Integer getOpticIndex() {
		return opticIndex;
	}
	public void setOpticIndex(Integer opticIndex) {
		this.opticIndex = opticIndex;
	}
	public BigDecimal getOpticWeight() {
		return opticWeight;
	}
	public void setOpticWeight(BigDecimal opticWeight) {
		this.opticWeight = opticWeight;
	}
	public BigDecimal getScore() {
		return score;
	}
	public void setScore(BigDecimal score) {
		this.score = score;
	}
	public Survey getSurvey() {
		return survey;
	}
	public void setSurvey(Survey survey) {
		this.survey = survey;
	}
	public List<Option> getOptionList() {
		return optionList;
	}
	public void setOptionList(List<Option> optionList) {
		this.optionList = optionList;
	}
	
}
