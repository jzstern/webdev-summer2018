package com.example.myapp2.repositories;
import org.springframework.data.repository.CrudRepository;
import com.example.myapp2.models.Exam;

public interface ExamRepository
extends CrudRepository<Exam, Integer>{

}