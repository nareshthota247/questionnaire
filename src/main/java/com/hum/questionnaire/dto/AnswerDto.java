package com.hum.questionnaire.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

public class AnswerDto {

	@Positive(message = "should be positive")
	private Integer id;
	@NotBlank
	private String selectedOption;
	
	public AnswerDto() {
		super();
	}

	public AnswerDto(Integer id, String answer) {
		super();
		this.id = id;
		this.selectedOption = answer;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSelectedOption() {
		return selectedOption;
	}

	public void setSelectedOption(String answer) {
		this.selectedOption = answer;
	}

}
