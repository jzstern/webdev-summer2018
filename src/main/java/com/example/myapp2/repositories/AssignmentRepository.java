package com.example.myapp2.repositories;
import org.springframework.data.repository.CrudRepository;
import com.example.myapp2.models.Assignment;

public interface AssignmentRepository extends CrudRepository<Assignment, Integer> {

}