package com.example.myapp2.repositories.QuestionRepositories;
import org.springframework.data.repository.CrudRepository;
import com.example.myapp2.models.Questions.EssayQuestion;

public interface EssayQuestionRepository extends CrudRepository<EssayQuestion, Integer> {

}