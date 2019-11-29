package com.hum.questionnaire.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hum.questionnaire.model.PointsEvaluation;

@Repository
public interface PointsEvaluationRepository extends JpaRepository<PointsEvaluation, Integer> {

}
