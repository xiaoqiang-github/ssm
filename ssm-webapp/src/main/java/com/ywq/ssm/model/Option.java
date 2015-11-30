package com.ywq.ssm.model;

import java.math.BigDecimal;

public class Option {
	private String optionId;
	private String optionName;
	private Integer optionIndex;
	private BigDecimal optionWeight;
	
	private Optic optic;

	public String getOptionId() {
		return optionId;
	}

	public void setOptionId(String optionId) {
		this.optionId = optionId;
	}

	public String getOptionName() {
		return optionName;
	}

	public void setOptionName(String optionName) {
		this.optionName = optionName;
	}

	public Integer getOptionIndex() {
		return optionIndex;
	}

	public void setOptionIndex(Integer optionIndex) {
		this.optionIndex = optionIndex;
	}

	public BigDecimal getOptionWeight() {
		return optionWeight;
	}

	public void setOptionWeight(BigDecimal optionWeight) {
		this.optionWeight = optionWeight;
	}

	public Optic getOptic() {
		return optic;
	}

	public void setOptic(Optic optic) {
		this.optic = optic;
	}

	
	
}
