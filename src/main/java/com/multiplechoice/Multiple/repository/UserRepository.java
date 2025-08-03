package com.multiplechoice.Multiple.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.multiplechoice.Multiple.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {
	
	@Query("select u from user u where u.roll = :roll")
    List<User> findByRollAdmin(@Param("roll") String roll);


}
