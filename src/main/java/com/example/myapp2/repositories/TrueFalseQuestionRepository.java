package com.example.myapp2.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.myapp2.models.TrueFalseQuestion;

public interface TrueFalseQuestionRepository
	extends CrudRepository<TrueFalseQuestion, Integer> {
	
}