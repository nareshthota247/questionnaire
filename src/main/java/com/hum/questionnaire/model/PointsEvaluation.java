package com.hum.questionnaire.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PointsEvaluation {
	
	@Id
	private Integer id;
	private Integer minPoints;
	private Integer maxPoints;
	private String message;
	
	public PointsEvaluation() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getMin() {
		return minPoints;
	}

	public void setMin(Integer min) {
		this.minPoints = min;
	}

	public Integer getMax() {
		return maxPoints;
	}

	public void setMax(Integer max) {
		this.maxPoints = max;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	

}
