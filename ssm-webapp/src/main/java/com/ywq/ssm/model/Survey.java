package com.ywq.ssm.model;

import java.util.Date;
import java.util.List;

public class Survey {
	private String surveyId;
	private String surveyName;
	private String memo;
	private Date startTime;
	private Date endTime;
	private String creator;
	private Date createTime;
	private Date modifyTime;
	
	private List<Optic> opticList;

	public String getSurveyId() {
		return surveyId;
	}

	public void setSurveyId(String surveyId) {
		this.surveyId = surveyId;
	}

	public String getSurveyName() {
		return surveyName;
	}

	public void setSurveyName(String surveyName) {
		this.surveyName = surveyName;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	public List<Optic> getOpticList() {
		return opticList;
	}

	public void setOpticList(List<Optic> opticList) {
		this.opticList = opticList;
	}

	@Override
	public String toString() {
		return "Survey [surveyId=" + surveyId + ", surveyName=" + surveyName
				+ ", memo=" + memo + ", startTime=" + startTime + ", endTime="
				+ endTime + ", creator=" + creator + ", createTime="
				+ createTime + ", modifyTime=" + modifyTime + ", opticList="
				+ opticList + "]";
	}
	
}
