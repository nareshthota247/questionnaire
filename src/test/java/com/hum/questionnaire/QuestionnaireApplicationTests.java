package com.hum.questionnaire;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hum.questionnaire.dto.AnswerDto;
import com.hum.questionnaire.dto.ResultDto;
import com.hum.questionnaire.service.QuestionnaireService;

@SpringBootTest
@AutoConfigureMockMvc
class QuestionnaireApplicationTests {

	@Autowired
	QuestionnaireService  questionnaireServiceImpl;
	
	@Autowired
	ObjectMapper mapper;
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void test() throws Exception{
		ResultDto finalPoints = questionnaireServiceImpl.calculateFinalScore(Arrays.asList(new AnswerDto(1, "A"), new AnswerDto(2, "A"), new AnswerDto(3, "A")));
		assertEquals(Integer.valueOf("13"), finalPoints.getTotalPoints());
	}
	
	@Test
	public void test_get_question() throws Exception{
		mockMvc.perform(get("/questionnaire"))
				.andExpect(status().isOk()).andReturn();
	}
	
	@Test
	public void test_post_restult() throws Exception{
		mockMvc.perform(post("/questionnaire").contentType(MediaType.APPLICATION_JSON)
				.content(mapper.writeValueAsBytes(Arrays.asList(new AnswerDto(1, "A"), new AnswerDto(2, "A"), new AnswerDto(3, "A")))))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.acquiredPoints").value("8")).andReturn();
	}
}
