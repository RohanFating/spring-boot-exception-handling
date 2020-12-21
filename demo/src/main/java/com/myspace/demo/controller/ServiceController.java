package com.myspace.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.myspace.demo.exception.ApiRuntimeException;
import com.myspace.demo.models.User;
import com.myspace.demo.repository.UserRepository;

@RestController()
public class ServiceController {

	@Autowired
	private UserRepository userRepository;

	@GetMapping("/user/{id}")
	public User getUsers(@PathVariable("id") int id) {
		List<User> list = userRepository.findAll();
		User u = list.size() > id ? list.get(id) : null;
		if(u == null)  {
			throw new ApiRuntimeException("Opps! users are not available");
		}
		
		return u;
	}

	@GetMapping("/user/getAllUsers")
	public List<User> geAlltUsers() {
		
		List<User>  us = userRepository.findAll();
		if(us == null || us.size() < 1)  {
			throw new ApiRuntimeException("Opps! users are not available");
		}
		return userRepository.findAll();
	}

	@PostMapping("/user/saveUsers")
	public User saveUser(@RequestBody User user) {
		System.out.println("+++++++++++++ Inside saveUser ++++++++++++++ " + user.toString());
		userRepository.save(user);
		return user;
	}
}
