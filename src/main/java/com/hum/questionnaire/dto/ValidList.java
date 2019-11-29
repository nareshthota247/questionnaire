package com.hum.questionnaire.dto;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import com.google.common.collect.ForwardingList;

public class ValidList<T> extends ForwardingList<T> {

	  private List<@Valid T> list;

	  public ValidList() {
	    this(new ArrayList<>());
	  }

	  public ValidList(List<@Valid T> list) {
	    this.list = list;
	  }

	  @Override
	  protected List<T> delegate() {
	    return list;
	  }

	  public List<T> getList() {
	    return list;
	  }
	}
