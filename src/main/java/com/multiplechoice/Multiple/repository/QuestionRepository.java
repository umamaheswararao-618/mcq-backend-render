package com.multiplechoice.Multiple.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.multiplechoice.Multiple.model.Question;
public interface QuestionRepository extends JpaRepository<Question, Long> {

	
}
