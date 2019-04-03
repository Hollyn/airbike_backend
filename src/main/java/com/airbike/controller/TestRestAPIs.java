package com.airbike.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.airbike.model.User;
import com.airbike.repository.UserRepository;

@RestController
public class TestRestAPIs {
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/api/test/user")
//	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	@PreAuthorize("hasRole('USER')")
	public List<User> userAccess() {
		//return ">>> User Contents!";
		return userRepository.findAll();
	}

	@GetMapping("/api/test/pm")
	@PreAuthorize("hasRole('USER')")
//	@PreAuthorize("hasRole('PM') or hasRole('ADMIN')")
	public String projectManagementAccess() {
		return ">>> Board Management Project";
	}
	
	@GetMapping("/api/test/admin")
//	@PreAuthorize("hasRole('ADMIN')")
	@PreAuthorize("hasRole('USER')")
	public String adminAccess() {
		return ">>> Admin Contents";
	}
	
}