package com.example.myapp2.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.myapp2.models.Widget;

public interface WidgetRepository 
	extends CrudRepository<Widget, Integer>{

}
