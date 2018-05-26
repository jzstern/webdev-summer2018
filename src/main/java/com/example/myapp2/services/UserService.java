package com.example.myapp2.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.myapp2.repositories.UserRepository;

import com.example.myapp2.models.User;

@RestController
public class UserService {
	@Autowired
	UserRepository repository;
	
	@DeleteMapping("/api/user/{userId}")
	public void deleteUser(@PathVariable("userId") int id) {
		repository.deleteById(id);
	}

	@PostMapping("/api/user")
	public User createUser(@RequestBody User user) {
		return repository.save(user);
	}

	@PostMapping("/api/login")
	public List<User> login(@RequestBody User user) {
		return (List<User>) repository.findUserByCredentials(user.getUsername(), user.getPassword());
	}

	@GetMapping("/api/user")
	public List<User> findAllUsers() {
		return (List<User>) repository.findAll();
	}
	
	@GetMapping("/api/user-string/{username}")
	public User findUserByUsername(@PathVariable("username") String username) {
		List<User> data = ((List<User>) repository.findUserByUsername(username));
		if(data.isEmpty()) {
			return new User();
		}
		else {
			return data.get(0);
		}
	}
	
	@PostMapping("/api/register")
	public User register(@RequestBody User user) {
//		UserService userService = new UserService();
//		User u = userService.findUserById(user.getId());
//	
//		if (u == null) userService.createUser(user);
//	
//		session.setAttribute("user", user);
//		return user;
		
		if (((List<User>)repository.findUserByUsername(user.getUsername())).size() == 0) {
			return this.createUser(user);
		} else {
			return null;
		}
	}

	@PutMapping("/api/user/{userId}")
	public User updateUser(@PathVariable("userId") int userId, @RequestBody User newUser) {
		Optional<User> data = repository.findById(userId);
		if (data.isPresent()) {
			User user = data.get();
			if (newUser.getUsername() != null) {
				user.setUsername(newUser.getUsername());
			}
			if (newUser.getPassword() != null) {
				user.setPassword(newUser.getPassword());
			}
			if (newUser.getFirstName() != null) {
				user.setFirstName(newUser.getFirstName());
			}
			if (newUser.getLastName() != null) {
				user.setLastName(newUser.getLastName());
			}
			if (newUser.getEmail() != null) {
				user.setEmail(newUser.getEmail());
			}
			if (newUser.getPhoneNumber() != null) {
				user.setPhoneNumber(newUser.getPhoneNumber());
			}
			if (newUser.getBirthday() != null) {
				user.setBirthday(newUser.getBirthday());
			}
			if (newUser.getRole() != null) {
				user.setRole(newUser.getRole());
			}
			repository.save(user);
			return user;
		} else {
			return null;
		}
	}

	@GetMapping("/api/user/{userId}")
	public User findUserById(@PathVariable("userId") int userId) {
		Optional<User> data = repository.findById(userId);
		if(data.isPresent()) {
			return data.get();
		}
		return null;
	}
}