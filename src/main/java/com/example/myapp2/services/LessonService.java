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
	
	@PostMapping("/api/course/{courseId}/module/{moduleId}/lesson")
	public Lesson createLesson(@PathVariable("moduleId") int moduleId, @PathVariable("courseId") int courseId, @RequestBody Lesson lesson) {
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
	
	@GetMapping("api/lesson/{lessonId}")
	public Lesson findLessonById(@PathVariable("lessonId") int lessonId) {
		Optional<Lesson> data = lessonRepository.findById(lessonId);
		
		if (data.isPresent()) {
			return data.get();
		} else {
			return null;
		}
	}
}
