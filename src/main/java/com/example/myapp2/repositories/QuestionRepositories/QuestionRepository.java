package com.example.myapp2.repositories.QuestionRepositories;
import org.springframework.data.repository.CrudRepository;
import com.example.myapp2.models.Questions.Question;

public interface QuestionRepository extends CrudRepository<Question, Integer> {

}