package com.hum.questionnaire.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hum.questionnaire.dto.AnswerDto;
import com.hum.questionnaire.dto.QuestionDto;
import com.hum.questionnaire.dto.ResultDto;
import com.hum.questionnaire.exceptionhandeling.NoRecordException;
import com.hum.questionnaire.model.MultipleOption;
import com.hum.questionnaire.model.PointsEvaluation;
import com.hum.questionnaire.model.Question;
import com.hum.questionnaire.repository.MultipleOptionRepository;
import com.hum.questionnaire.repository.PointsEvaluationRepository;
import com.hum.questionnaire.repository.QuestionRepository;

@Service
public class QuestionnaireServiceImpl implements QuestionnaireService {

	private static final Logger logger = LoggerFactory.getLogger(QuestionnaireServiceImpl.class);
	
	@Autowired
	QuestionRepository qusRepo;

	@Autowired
	PointsEvaluationRepository pointsEvaluationRepository;

	@Autowired
	MultipleOptionRepository multipleOptionRepository;

	@Autowired
	ModelMapper modelMapper;

	@Override
	public ResultDto calculateFinalScore(List<AnswerDto> questionDtoList) {

		List<Question> qusList = qusRepo.findAll();
		Optional<Integer> totalPoints = multipleOptionRepository.findSumOfPoints();

		if (qusList.isEmpty() || !totalPoints.isPresent()) {
			logger.error("Database error");
			throw new NoRecordException("Database configuration error");
		}

		List<List<List<Integer>>> list = questionDtoList.stream()
				.map(qusDto -> qusList.stream().filter(qus -> qus.getId().equals(qusDto.getId()))
						.map(qus -> qus.getOptions().stream()
								.filter(qusOpt -> qusOpt.getOption().equalsIgnoreCase(qusDto.getSelectedOption()))
								.map(MultipleOption::getPoints).collect(Collectors.toList()))
						.collect(Collectors.toList()))
				.collect(Collectors.toList());

		Integer pointsGained = list.stream().flatMap(Collection::stream).flatMap(Collection::stream).reduce(0,
				(i, j) -> i + j);

		logger.debug("pointsGained :{}",pointsGained);
		List<PointsEvaluation> pointsList = pointsEvaluationRepository.findAll();

		Optional<String> message = pointsList.stream().filter(
				pointsEvaluation -> pointsGained.compareTo(pointsEvaluation.getMin()) >= 0 && pointsGained.compareTo(
						pointsEvaluation.getMax() == null ? Integer.MAX_VALUE : pointsEvaluation.getMax()) <= 0)
				.map(PointsEvaluation::getMessage).findFirst();
		logger.debug("pointsGained :{}",message.orElse("default"));

		return new ResultDto(totalPoints.orElse(0), pointsGained, message.orElse("default"));

	}

	@Override
	public List<QuestionDto> getAllQuestions() {
		List<Question> questionList = qusRepo.findAll();
		
		if (questionList.isEmpty()) {
			logger.error("Database error");
			throw new NoRecordException("Database configuration error");
		}
		logger.debug("questionList size {}",questionList.size());
		return questionList.stream().map(question -> modelMapper.map(question, QuestionDto.class))
				.collect(Collectors.toList());
	}
}
