package com.example.myapp2.services.QuestionServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.myapp2.models.Exam;
import com.example.myapp2.models.Questions.EssayQuestion;
import com.example.myapp2.repositories.ExamRepository;
import com.example.myapp2.repositories.QuestionRepositories.EssayQuestionRepository;
import com.example.myapp2.repositories.QuestionRepositories.QuestionRepository;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class EssayQuestionService {
	@Autowired
	QuestionRepository questionRepository;
	@Autowired
	EssayQuestionRepository essayQuestionRepository;
	@Autowired
	ExamRepository examRepository;
	
	@PostMapping("/api/exam/{examId}/essay")
	public EssayQuestion createEssayQuestion(@RequestBody EssayQuestion essayQuestion, @PathVariable("examId") int examId) {
		Optional<Exam> data = examRepository.findById(examId);
			
		System.out.println("examId: " + examId);
		System.out.println("data: ");
		System.out.println(data);
		
		if (data.isPresent()) {
			essayQuestion.setExam(data.get());
			return essayQuestionRepository.save(essayQuestion);
		} else {
			return null;
		}
	}
	
	@PutMapping("/api/essay/{essayId}")
	public EssayQuestion updateEssay(@PathVariable("essayId") int essayId, @RequestBody EssayQuestion newEssayQuestion) {
		Optional<EssayQuestion> data = essayQuestionRepository.findById(essayId);
		
		if (data.isPresent()) {
			EssayQuestion eq = data.get();
			eq.setTitle(newEssayQuestion.getTitle());
			eq.setDescription(newEssayQuestion.getDescription());
			eq.setPoints(newEssayQuestion.getPoints());
			return essayQuestionRepository.save(eq);
		} else {
			return null;
		}
	}
	
	@DeleteMapping("/api/essay/{essayId}")
	public void deleteEssayQuestion(@PathVariable("essayId") int essayId) {
		questionRepository.deleteById(essayId);
	}
	
	@GetMapping("/api/essay/{questionId}")
	public EssayQuestion findQuestionById(@PathVariable("questionId") int questionId) {
		Optional<EssayQuestion> data = essayQuestionRepository.findById(questionId);
				
		if (data.isPresent()) {
			return data.get();
		}
		return null;
	}
}