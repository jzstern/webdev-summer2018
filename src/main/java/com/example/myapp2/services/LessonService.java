package com.example.myapp2.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.myapp2.models.Course;
import com.example.myapp2.models.Lesson;
import com.example.myapp2.models.Module;
import com.example.myapp2.repositories.CourseRepository;
import com.example.myapp2.repositories.LessonRepository;
import com.example.myapp2.repositories.ModuleRepository;


@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class LessonService {
	@Autowired
	CourseRepository courseRepository;
	@Autowired
	ModuleRepository moduleRepository;
	@Autowired
	LessonRepository lessonRepository;	
	
	@PutMapping("api/lesson/{lessonId}")
	public Lesson updateLesson(@PathVariable("lessonId") int lessonId, @RequestBody Lesson updatedLesson) {
		Optional<Lesson> data = lessonRepository.findById(lessonId);
		
		if (data.isPresent()) {
			Lesson lesson = data.get();
			
			if (updatedLesson.getTitle() != null) {
				lesson.setTitle(updatedLesson.getTitle());
			}
			if (updatedLesson.getModule() != null) {
				lesson.setModule(updatedLesson.getModule());
			}
			lessonRepository.save(lesson);
			return lesson;
		} else {
			return null;
		}
	}
	
	@GetMapping("/api/lesson")
	public Iterable<Lesson> findAllLessons() {
		return lessonRepository.findAll(); 
	}
	
	@GetMapping("api/lesson/{lessonId}")
	public Lesson findLessonById(@PathVariable("lessonId") int lessonId) {
		Optional<Lesson> data = lessonRepository.findById(lessonId);
		
		if (data.isPresent()) {
			return data.get();
		} else {
			return null;
		}
	}
	
	@GetMapping("/api/course/{courseId}/module/{moduleId}/lesson")
	public List<Lesson> findAllLessonsForModule(@PathVariable("moduleId") int moduleId) {
		Optional<Module> data = moduleRepository.findById(moduleId);
		
		if (data.isPresent()) {
			Module m = data.get();
			return m.getLessons();
		} 
		else {
			List<Lesson> lessons = new ArrayList<>();
			lessons.add(new Lesson());
			return lessons;
//			return null;
		}
	}
	
	@PostMapping("/api/course/{courseId}/module/{moduleId}/lesson")
	public Lesson createLesson(@PathVariable("moduleId") int moduleId, 
			@PathVariable("courseId") int courseId, @RequestBody Lesson lesson) {
		Optional<Module> data = moduleRepository.findById(moduleId);
		
		if (data.isPresent()) {
			Module m = data.get();
			lesson.setModule(m);
			Course course = courseRepository.findById(courseId).get();
			course.setModified(new Date());
			return lessonRepository.save(lesson);
		}
		return null;
	}
	
	@DeleteMapping("/api/lesson/{lessonId}")
	public void deleteLesson(@PathVariable("lessonId") int lessonId) {
		Optional<Lesson> lesson = lessonRepository.findById(lessonId);
		if (lesson.isPresent()) {
			Lesson l = lesson.get();
			Module module = l.getModule();
			Course course = module.getCourse();
			course.setModified(new Date());
		}
		lessonRepository.deleteById(lessonId);
	}
}
