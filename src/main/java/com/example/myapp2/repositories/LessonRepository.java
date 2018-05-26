package com.example.myapp2.repositories;

import org.springframework.data.repository.CrudRepository;
import com.example.myapp2.models.Lesson;

public interface LessonRepository extends CrudRepository<Lesson, Integer>{

}