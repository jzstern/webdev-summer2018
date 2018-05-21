package com.example.myapp2.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import com.example.myapp2.models.User;

public interface UserRepository
	extends CrudRepository<User, Integer> {
	@Query("SELECT u FROM User u WHERE u.username=:username AND u.password=:password")
	Iterable<User> findUserByCredentials(
		@Param("username") String username,
		@Param("password") String password);
	
	@Query("SELECT u FROM User u WHERE u.username=:username")
	Iterable<User> findUserByUsername(
		@Param("username") String username);
	
	@Query("INSERT u INTO User")
	Optional<User> register(
			@Param("user") Iterable<User> u);
}