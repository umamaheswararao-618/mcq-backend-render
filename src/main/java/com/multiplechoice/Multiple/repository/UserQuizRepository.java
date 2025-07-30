package com.multiplechoice.Multiple.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.multiplechoice.Multiple.model.UserQuiz;

public interface UserQuizRepository extends JpaRepository<UserQuiz,Long> {
	@Query("SELECT u FROM UserQuiz u WHERE u.type = :type and u.user.id=:id")
	List<UserQuiz> getUserQuestionType(@Param("type") String type,@Param("id") Long id);


}
