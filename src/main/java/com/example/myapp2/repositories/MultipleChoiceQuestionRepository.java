package com.example.myapp2.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.myapp2.models.MultipleChoiceQuestion;
import com.example.myapp2.models.TrueFalseQuestion;

public interface MultipleChoiceQuestionRepository
	extends CrudRepository<MultipleChoiceQuestion, Integer> {
	
}