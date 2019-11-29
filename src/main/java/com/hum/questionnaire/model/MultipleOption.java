package com.hum.questionnaire.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class MultipleOption {
	
	@Id
	private Integer id;
	
	private String description;
	
	@Column(name="OPTION_VALUE", length=1, columnDefinition="CHAR")
	private String option;
	
	private Integer points;
	
	@ManyToOne
    @JoinColumn(name="question_id", nullable=false)
	@JsonBackReference
    private Question question;
	
	public MultipleOption() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPoints() {
		return points;
	}

	public void setPoints(Integer points) {
		this.points = points;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getOption() {
		return option;
	}

	public void setOption(String option) {
		this.option = option;
	}

	
}
