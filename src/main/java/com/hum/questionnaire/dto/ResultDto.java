package com.hum.questionnaire.dto;

public class ResultDto {

	private Integer acquiredPoints;
	private Integer totalPoints;
	private String message;

	public ResultDto() {
	}
	

	public ResultDto(Integer totalPoints, Integer acquiredPoints, String message) {
		super();
		this.totalPoints = totalPoints;
		this.acquiredPoints = acquiredPoints;
		this.message = message;
	}


	public Integer getTotalPoints() {
		return totalPoints;
	}

	public void setTotalPoints(Integer totalPoints) {
		this.totalPoints = totalPoints;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}


	public Integer getAcquiredPoints() {
		return acquiredPoints;
	}


	public void setAcquiredPoints(Integer acquiredPoints) {
		this.acquiredPoints = acquiredPoints;
	}

}
