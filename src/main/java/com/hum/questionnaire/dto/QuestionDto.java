package com.hum.questionnaire.dto;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;

public class QuestionDto {

	private Integer id;
	private String question;
	@JsonManagedReference
	private Set<MultipleOptionDto> options;
	
	public QuestionDto() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public Set<MultipleOptionDto> getOptions() {
		return options;
	}

	public void setOptions(Set<MultipleOptionDto> options) {
		this.options = options;
	}
	
}
