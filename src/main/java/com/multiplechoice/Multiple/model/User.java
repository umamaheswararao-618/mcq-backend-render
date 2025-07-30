package com.multiplechoice.Multiple.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	@Column(nullable = false,unique =true)
	private String email;
	
	@Column(nullable = false)
	private String passWord;
	
	@Column(nullable = false)
	private String roll;

	public User(Long id, String email, String passWord, String roll) {
		super();
		this.id = id;
		this.email = email;
		this.passWord = passWord;
		this.roll = roll;
	}

	
	public User()
	{
		
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassWord() {
		return passWord;
	}


	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}


	public String getRoll() {
		return roll;
	}


	public void setRoll(String roll) {
		this.roll = roll;
	}


	
	

}
