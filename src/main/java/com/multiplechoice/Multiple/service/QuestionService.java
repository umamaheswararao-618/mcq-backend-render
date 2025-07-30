package com.multiplechoice.Multiple.service;

import com.multiplechoice.Multiple.model.Question;
import com.multiplechoice.Multiple.model.User;
import com.multiplechoice.Multiple.model.UserQuiz;
import com.multiplechoice.Multiple.repository.QuestionRepository;
import com.multiplechoice.Multiple.repository.UserQuizRepository;
import com.multiplechoice.Multiple.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private UserQuizRepository quizRepository;
    public Question saveQuestion(Question question) {
        return questionRepository.save(question);
    }

    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }

    public Question getQuestionById(long id) {
        return questionRepository.findById(id).orElseThrow(() -> new RuntimeException("Question not found"));
    }
    public void deleteQuestionById(Long id) {
        questionRepository.deleteById(id);
    }

	public void saveUser(User user) {
		// TODO Auto-generated method stub
		userRepository.save(user);
	}

	public User getUserById(long id) {
		// TODO Auto-generated method stub
		 return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
	}
	public void saveUserQuiz(List<UserQuiz> us)
	{
		for(UserQuiz u:us)
		{
			quizRepository.save(u);
		}
	}
	
	public User getUserByEmail(String Email)
	{
		List<User>Users=userRepository.findAll();
		for(User u:Users)
		{
			if(u.getEmail().equals(Email))
			{
				return u;
			}
		}
		User u=new User();
		u.setEmail("Invalid");
		return u;
	}
   
	public List<UserQuiz> getUserQuestionType(String type, Long id)
	{
		return quizRepository.getUserQuestionType(type,id);
	}
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	public List<UserQuiz> viewQuiz() {
		// TODO Auto-generated method stub
		
		return quizRepository.findAll();
	}

	public boolean findbyEmail(String email) {
		// TODO Auto-generated method stub
		List<User>u=getAllUsers();
		for(User ur:u)
		{
			if(ur.getEmail().equals(email))
			{
				return true;
			}
		}
		return false;
	}

}