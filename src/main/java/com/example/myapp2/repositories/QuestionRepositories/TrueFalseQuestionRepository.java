package com.example.myapp2.repositories.QuestionRepositories;

import org.springframework.data.repository.CrudRepository;

import com.example.myapp2.models.Questions.TrueFalseQuestion;

public interface TrueFalseQuestionRepository
	extends CrudRepository<TrueFalseQuestion, Integer> {
	
}