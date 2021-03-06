package com.example.myapp2.services;

import java.util.Optional;

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
import com.example.myapp2.repositories.CourseRepository;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class CourseService {
	@Autowired
	CourseRepository courseRepository;
	
	@GetMapping("/api/course")
	public Iterable<Course> findAllCourses() {
		return courseRepository.findAll(); 
	}
	
	@GetMapping("/api/course/{courseId}")
	public Course findCourseById(@PathVariable("courseId") int id) {
		Optional<Course> data = courseRepository.findById(id);
		
		if (data.isPresent()) {
			return data.get();
		} else {
			return null;
		}
	}

	@PostMapping("/api/course")
	public Course createCourse(@RequestBody Course course) {
		return courseRepository.save(course);
	}
	
	@PutMapping("/api/course/{courseId}")
	public Course updateCourse(@PathVariable("courseId") int courseId, @RequestBody Course newCourse) {
		Optional<Course> data = courseRepository.findById(courseId);
		
		if (data.isPresent()) {
			Course course = data.get();
			if (newCourse.getTitle() != null) {
				course.setTitle(newCourse.getTitle());
			}
			if (newCourse.getCreated() != null) {
				course.setCreated(newCourse.getCreated());
			}
			if (newCourse.getModified() != null) {
				course.setModified(newCourse.getModified());
			}
			courseRepository.save(course);
			return course;
		} else {
			return null;
		}
	}

	@DeleteMapping("/api/course/{courseId}")
	public void deleteCourse(@PathVariable("courseId") int id) {
		courseRepository.deleteById(id);
	}
}
