package com.hum.questionnaire.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
public class Question {
	
	@Id
	private Integer id;
	private String question;
	@OneToMany(mappedBy="question", fetch=FetchType.EAGER)
	@JsonManagedReference
	private Set<MultipleOption> options;
	
	public Question() {
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
	public Set<MultipleOption> getOptions() {
		return options;
	}
	public void setOptions(Set<MultipleOption> options) {
		this.options = options;
	}
	
	
}
