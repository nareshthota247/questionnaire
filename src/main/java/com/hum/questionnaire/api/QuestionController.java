package com.hum.questionnaire.api;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hum.questionnaire.dto.AnswerDto;
import com.hum.questionnaire.dto.QuestionDto;
import com.hum.questionnaire.dto.ResultDto;
import com.hum.questionnaire.dto.ValidList;
import com.hum.questionnaire.service.QuestionnaireService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/questionnaire")
@Api( value = "/questionnaire")
public class QuestionController {
	
	@Autowired
	QuestionnaireService questionnaireServiceImpl;
	
	@ApiOperation(value = "Rest endpoint to get all the Questions", response = QuestionDto.class, responseContainer = "List")
	@GetMapping(produces = { "application/json" })
	public ResponseEntity<List<QuestionDto>> getQuestionnaire(){
		return ResponseEntity.ok(questionnaireServiceImpl.getAllQuestions());
	}
	
	@ApiOperation(value = "Rest endpoint to calculate points", response = ResultDto.class)
	@PostMapping(consumes = { "application/json" }, produces = { "application/json" })
	public ResponseEntity<ResultDto> getResult(@Valid @RequestBody ValidList<AnswerDto> questionDtoList){
		return ResponseEntity.ok(questionnaireServiceImpl.calculateFinalScore(questionDtoList));
	}

}
