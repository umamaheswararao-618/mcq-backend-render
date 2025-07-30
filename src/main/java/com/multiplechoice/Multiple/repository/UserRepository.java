package com.multiplechoice.Multiple.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.multiplechoice.Multiple.model.User;

public interface UserRepository extends JpaRepository<User,Long> {
	
	

}
