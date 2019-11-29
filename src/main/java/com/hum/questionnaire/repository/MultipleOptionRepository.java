package com.hum.questionnaire.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hum.questionnaire.model.MultipleOption;

@Repository
public interface MultipleOptionRepository extends JpaRepository<MultipleOption, Integer>{

	@Query(value = "SELECT SUM(MAX_POINTS_PER_QUESTION ) FROM (SELECT MAX(POINTS ) AS MAX_POINTS_PER_QUESTION FROM MULTIPLE_OPTION  GROUP BY (QUESTION_ID ) )", nativeQuery = true)
	Optional<Integer> findSumOfPoints();
}
