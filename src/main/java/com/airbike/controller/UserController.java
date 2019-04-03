package com.airbike.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.airbike.message.request.EditUserForm;
import com.airbike.model.Role;
import com.airbike.model.RoleName;
import com.airbike.model.User;
import com.airbike.repository.RoleRepository;
import com.airbike.repository.UserRepository;
import com.airbike.utils.ErrorException;
import com.google.gson.Gson;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	
	@GetMapping("/users")
//	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public List<User> getAllUser() {
		return userRepository.findAll();
	}
	

	// Edit a user
	@PostMapping("/user/{id}")
	public ResponseEntity<?> editUser(@PathVariable("id") long id, @Valid @RequestBody EditUserForm user) {
		

		if (!userRepository.existsByEmail(user.getEmail())) {
			return ResponseEntity.ok(new Gson().toJson(new ErrorException(409, "User does not exist")));
		}

		// get the user
		User mUser = userRepository.findUserById(id);

		mUser.setFirstname(user.getFirstname());
		mUser.setLastname(user.getLastname());
		mUser.setAddress(user.getAddress());
		mUser.setCity(user.getCity());
		mUser.setCountry(user.getCountry());
		mUser.setEmail(user.getEmail());
		mUser.setPhone(user.getPhone());
		mUser.setUsername(user.getUsername());

		Set<String> strRoles = user.getRole();
		Set<Role> roles = new HashSet<>();


		strRoles.forEach(role -> {
			switch (role) {
			case "admin":
				Role adminRole = roleRepository.findByName(RoleName.ROLE_ADMIN)
						.orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
				roles.add(adminRole);

				break;
			case "renter":
				Role pmRole = roleRepository.findByName(RoleName.ROLE_RENTER)
						.orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
				roles.add(pmRole);

				break;
			default:
				Role userRole = roleRepository.findByName(RoleName.ROLE_USER)
						.orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
				roles.add(userRole);
			}
		});

		mUser.setRoles(roles);

		return ResponseEntity.ok(userRepository.save(mUser));
	}
}
