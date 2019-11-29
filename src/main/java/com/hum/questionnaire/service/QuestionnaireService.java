package com.hum.questionnaire.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hum.questionnaire.dto.AnswerDto;
import com.hum.questionnaire.dto.QuestionDto;
import com.hum.questionnaire.dto.ResultDto;

@Service
public interface QuestionnaireService {
	
	ResultDto calculateFinalScore(List<AnswerDto> questionDtoList);
	List<QuestionDto> getAllQuestions();

}
