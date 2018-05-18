package com.example.myapp2.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.example.myapp2.models.Hello;

@Service
public interface HelloRepository
	extends CrudRepository<Hello, Integer> {
}