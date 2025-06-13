package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.UserDto;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService service;
	
	@PostMapping("/create")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<User> createPremium(@Valid @RequestBody UserDto dto) {
		 User user=service.createUsersPremium(dto);
		 return new ResponseEntity<>(user,HttpStatus.CREATED);
	}
	@GetMapping("allusers")
	@ResponseStatus(HttpStatus.FOUND)
	 public List<User> getAllUsers() {
		 return service.getAllUsers();
	 }
	@GetMapping("get/{id}")
	@ResponseStatus(HttpStatus.FOUND)
	public User getUserById(@PathVariable Long id) {
		return service.getUserById(id);
	}
	@PutMapping("update/{id}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public User UpdateUsers(@PathVariable Long id,@Valid @RequestBody UserDto dto) {
		return service.UpdateUser(id, dto);
	}
	@DeleteMapping("delete/{id}")
	@ResponseStatus(HttpStatus.GONE)
	public String deleteUser(@PathVariable Long id) {
		return service.deleteUserById(id);
	}
	@PatchMapping("modify/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public User modifiedUser(@PathVariable Long id,@Valid @RequestBody UserDto dto) {
		return service.modifyUser(id, dto);
	}
}
