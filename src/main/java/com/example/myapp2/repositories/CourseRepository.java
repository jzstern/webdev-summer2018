package com.example.myapp2.repositories;
import org.springframework.data.repository.CrudRepository;
import com.example.myapp2.models.Course;

public interface CourseRepository extends CrudRepository<Course, Integer> {

}
