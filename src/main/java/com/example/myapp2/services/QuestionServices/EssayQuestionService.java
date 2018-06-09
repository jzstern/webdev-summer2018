package com.example.myapp2.services.QuestionServices;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.myapp2.models.Exam;
import com.example.myapp2.models.Questions.EssayQuestion;
import com.example.myapp2.repositories.ExamRepository;
import com.example.myapp2.repositories.QuestionRepositories.EssayQuestionRepository;
import com.example.myapp2.repositories.QuestionRepositories.QuestionRepository;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class EssayQuestionService {
	@Autowired
	QuestionRepository questionRepository;
	@Autowired
	EssayQuestionRepository essayRepository;
	@Autowired
	ExamRepository examRepository;
	
	@PostMapping("/api/exam/{examId}/essay")
	public EssayQuestion createEssayQuestion(@RequestBody EssayQuestion essay, @PathVariable("examId") int examId) {
		Optional<Exam> data = examRepository.findById(examId);
		if (data.isPresent()) {
			essay.setExam(data.get());
			return essayRepository.save(essay);
		} else {
			return null;
		}
	}
	
	@GetMapping("/api/essay/{questionId}")
	public EssayQuestion findFillQuestionById(@PathVariable("questionId") int questionId) {
		Optional<EssayQuestion> optional = essayRepository.findById(questionId);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}
	
	@DeleteMapping("/api/essay/{essayId}")
	public void deleteEssayQuestion(@PathVariable("essayId") int essayId) {
		questionRepository.deleteById(essayId);
	}
}