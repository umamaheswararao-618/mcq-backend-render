package com.multiplechoice.Multiple.model;

import java.util.List;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class UserQuiz {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
   private	Long id;
	
	@ManyToOne
	
	private User user;
   @ManyToOne
private Question question;
   
   @Column(nullable = false)
   private String marked;
   
   @Column(nullable = false)
   private String date;
   
   @Column(nullable=false)
   private String  type;
   
   
   
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public UserQuiz(User user) {
	this.user=user;
}
public UserQuiz(User user, Question question) {
	// TODO Auto-generated constructor stub
	this.user=user;
	this.question=question;
}
public Long getId() {
	return id;
}
public UserQuiz() {}

public Long UserId()
{
	return user.getId();
}

public void setId(Long id) {
	this.id = id;
}


public User getUser() {
	return user;
}

public void setUser(User user) {
	this.user = user;
}

public Question getQuestion() {
	return question;
}

public void setQuestion(Question question) {
	this.question = question;
}

public String getMarked() {
	return marked;
}

public void setMarked(String marked) {
	this.marked = marked;
}

public String getDate() {
	return date;
}

public void setDate(String date) {
	this.date = date;
}
   
   
}
