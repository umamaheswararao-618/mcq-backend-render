 package com.multiplechoice.Multiple.model;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Question {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable = false,unique = true)
	private String Questiontext;
	
	@Column(nullable = false)
	private String optionA;
	@Column(nullable = false)
	private String optionB;
	@Column(nullable = false)
	private String optionC;
	@Column(nullable = false)
	private String  optionD;
	@Column(nullable = false)
	 private String correctAnswer;
	@Column(nullable = false)
	private String type;
	
	public Question()
	{
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getQuestiontext() {
		return Questiontext;
	}

	public void setQuestiontext(String questiontext) {
		Questiontext = questiontext;
	}

	public String getOptionA() {
		return optionA;
	}

	public void setOptionA(String optionA) {
		this.optionA = optionA;
	}

	public String getOptionB() {
		return optionB;
	}

	public void setOptionB(String optionB) {
		this.optionB = optionB;
	}

	public String getOptionC() {
		return optionC;
	}

	public void setOptionC(String optionC) {
		this.optionC = optionC;
	}

	public String getOptionD() {
		return optionD;
	}

	public void setOptionD(String optionD) {
		this.optionD = optionD;
	}

	public String getCorrectAnswer() {
		return correctAnswer;
	}

	public void setCorrectAnswer(String correctAnswer) {
		this.correctAnswer = correctAnswer;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	 public Question(String questionText, String optionA, String optionB, String optionC, String optionD, String correctAnswer, String type) {
	        this.Questiontext = questionText;
	        this.optionA = optionA;
	        this.optionB = optionB;
	        this.optionC = optionC;
	        this.optionD = optionD;
	        this.correctAnswer = correctAnswer;
	        this.type = type;
	    }
	 
	 @Override
	    public String toString() {
	        return "Question{" +
	                "id=" + id +
	                ", questionText='" + Questiontext + '\'' +
	                ", optionA='" + optionA + '\'' +
	                ", optionB='" + optionB + '\'' +
	                ", optionC='" + optionC + '\'' +
	                ", optionD='" + optionD + '\'' +
	                ", correctAnswer='" + correctAnswer + '\'' +
	                ", type='" + type + '\'' +
	                '}';
	    }

}
