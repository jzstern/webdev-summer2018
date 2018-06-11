package com.example.myapp2.services;

import java.util.ArrayList;
import java.util.List;
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
import com.example.myapp2.models.Lesson;
import com.example.myapp2.models.Widget;
import com.example.myapp2.models.Questions.MultipleChoiceQuestion;
import com.example.myapp2.models.Questions.Question;
import com.example.myapp2.models.Questions.TrueFalseQuestion;
import com.example.myapp2.repositories.ExamRepository;
import com.example.myapp2.repositories.LessonRepository;
import com.example.myapp2.repositories.QuestionRepositories.EssayQuestionRepository;
import com.example.myapp2.repositories.QuestionRepositories.MultipleChoiceQuestionRepository;
import com.example.myapp2.repositories.QuestionRepositories.TrueFalseQuestionRepository;

@RestController
@CrossOrigin(origins = "*")
public class ExamService {
	@Autowired
	ExamRepository examRepository;
	@Autowired
	LessonRepository lessonRepository;
	@Autowired
	TrueFalseQuestionRepository trueFalseRepository;
	@Autowired
	EssayQuestionRepository essayRepository;
	@Autowired
	MultipleChoiceQuestionRepository mutiRepo;
	
	@PostMapping("/api/lesson/{lessonId}/exam")
	public Exam createExam(@RequestBody Exam exam, @PathVariable("lessonId") int lessonId) {
		Optional<Lesson> data = lessonRepository.findById(lessonId);
		
		if (data.isPresent()) {
			Lesson lesson = data.get();
			exam.setLesson(lesson);
			return examRepository.save(exam);
		} else {
			return null;
		}
	}
	
	@DeleteMapping("/api/exam/{examId}")
	public void deleteExam(@PathVariable("examId") int examId) {
		examRepository.deleteById(examId);
	}
	
	@GetMapping("/api/lesson/{lessonId}/exam")
	public List<Exam> findAllExamsForLesson(@PathVariable("lessonId") int lessonId) {
		Optional<Lesson> data = lessonRepository.findById(lessonId);
		if (data.isPresent()) {
			Lesson lesson = data.get();
			List<Widget> widgets = lesson.getWidgets();
			List<Exam> exams = new ArrayList<Exam>();
			for (Widget w : widgets) {
				if (w instanceof Exam) {
					exams.add((Exam) w);
				}
			}
			return exams;
		} else {
			return null;
		}
	}
	
	@GetMapping("/api/exam/{examId}")
	public Exam findExamById(@PathVariable("examId") int examId) {
		Optional<Exam> data = examRepository.findById(examId);
		
		if (data.isPresent()) {
			return data.get();
		} else {
			return null;
		}
	}
	
	@GetMapping("/api/exam")
	public List<Exam> findAllExams() {
		return (List<Exam>) examRepository.findAll();
	}

	@GetMapping("/api/multi/{questionId}")
	public MultipleChoiceQuestion findMultiQuestionById(@PathVariable("questionId") int questionId) {
		Optional<MultipleChoiceQuestion> optional = mutiRepo.findById(questionId);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	@GetMapping("/api/truefalse/{questionId}")
	public TrueFalseQuestion findTrueFalseQuestionById(@PathVariable("questionId") int questionId) {
		Optional<TrueFalseQuestion> optional = trueFalseRepository.findById(questionId);
		
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}
	
	@GetMapping("/api/exam/{examId}/question")
	public List<Question> findAllQuestionsForExam(@PathVariable("examId") int examId) {
		Optional<Exam> optionalExam = examRepository.findById(examId);
		
		if(optionalExam.isPresent()) {
			Exam exam = optionalExam.get();
			List<Question> questions = exam.getQuestions();
			int count = questions.size();
			return questions;
		}
		return null;
	}
}