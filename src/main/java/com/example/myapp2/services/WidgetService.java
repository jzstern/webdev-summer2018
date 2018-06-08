package com.example.myapp2.services;

//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.example.myapp2.models.Lesson;
//import com.example.myapp2.models.Widget;
//import com.example.myapp2.repositories.WidgetRepository;
//import com.example.myapp2.repositories.LessonRepository;
//
//import java.util.List;
//import java.util.Optional;
//
//@RestController
//@CrossOrigin(origins = "*")
//public class WidgetService {
//	@Autowired
//	WidgetRepository widgetRepository;
//	
//	@Autowired
//	LessonRepository lessonRepository;
//	
//	@GetMapping("/api/lesson/{lessonId}/widget")
//	public List<Widget> findAllWidgetsForLesson(@PathVariable("lessonId") int lessonId) {
//		Optional<Lesson> optionalLesson = lessonRepository.findById(lessonId);
//				
//		if (optionalLesson.isPresent()) {
//			Lesson lesson = optionalLesson.get();
//			
//			System.out.println("LESSON: " + lesson);
//			System.out.println("LESSON.getWidgets(): " + lesson.getWidgets());
//			
//			return lesson.getWidgets();
//		}
//		return null;
//	}
//	
//	@GetMapping("/api/widget")
//	public List<Widget> findAllWidgets() {
//		return (List<Widget>) widgetRepository.findAll();
//	}
//	
//	@GetMapping("/api/widget/{widgetId}")
//	public Widget findWidgetById(@PathVariable("courseId") int id) {
//		Optional<Widget> data = widgetRepository.findById(id);
//		
//		if (data.isPresent()) {
//			return data.get();
//		} else {
//			return null;
//		}
//	}
//		
//	@DeleteMapping("/api/widget/{widgetId}")
//	public void deleteWidget(@PathVariable("widgetId") int id) {
//		widgetRepository.deleteById(id);
//	}
//	
//	@PutMapping("/api/widget/{widgetId}")
//	public Widget updateWidget(@PathVariable("widgetId") int id, @RequestBody Widget newWidget) {
//		Optional<Widget> data = widgetRepository.findById(id);
//		
//		if (data.isPresent()) {
//			Widget widget = data.get();			
//
//			if (newWidget.getSize() != 0) {
//				widget.setSize(newWidget.getSize());
//			}
//			if (newWidget.getPosition() != 0) {
//				widget.setPosition(newWidget.getPosition());
//			}
//			if (newWidget.getText() != null) {
//				widget.setText(newWidget.getText());
//			}
//			if (newWidget.getUrl() != null) {
//				widget.setUrl(newWidget.getUrl());
//			}
//			if (newWidget.getName() != null) {
//				widget.setName(newWidget.getName());
//			}
//			if (newWidget.getWidgetType() != null) {
//				widget.setWidgetType(newWidget.getWidgetType());
//			}
//			
//			widget.setOrdered(newWidget.getOrdered());
//			
//			widgetRepository.save(widget);
//			return widget;
//		} else {
//			return null;
//		}
//	}
//	
//	@PostMapping("/api/widget/save")
//	public void saveAllWidgets(@RequestBody List<Widget> widgets) {
//		widgetRepository.deleteAll();
//		for (Widget widget : widgets) {
//			widgetRepository.save(widget);
//		}
//	}
//	
//}


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.myapp2.models.Lesson;
import com.example.myapp2.models.Widget;
import com.example.myapp2.repositories.LessonRepository;
import com.example.myapp2.repositories.WidgetRepository;

@RestController
@CrossOrigin(origins = "*")
public class WidgetService {
	@Autowired
	WidgetRepository repository;
	@Autowired
	LessonRepository lessonRepository;
	
	@GetMapping("/api/lesson/{lessonId}/widget")
	public List<Widget> findAllWidgetsForLesson(@PathVariable("lessonId") int lessonId) {
		Optional<Lesson> optionalLesson = lessonRepository.findById(lessonId);
		if(optionalLesson.isPresent()) {
			Lesson lesson = optionalLesson.get();
			List<Widget> ws = lesson.getWidgets();
			return ws;
		}
		return null;
	}
	
	@PostMapping("/api/widget/save")
	public void saveAllWidgets(@RequestBody
			List<Widget> widgets) {
		repository.deleteAll();
		for(Widget widget: widgets) {
			repository.save(widget);
		}
	}
	
	@GetMapping("/api/widget")
	public List<Widget> findAllWidgets() {
		return (List<Widget>) repository.findAll();
	}
}