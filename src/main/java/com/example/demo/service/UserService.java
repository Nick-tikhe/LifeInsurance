package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.UserDto;
import com.example.demo.entity.User;
import com.example.demo.exceptions.UserNotFoundException;
import com.example.demo.repository.UserRepo;


@Service
public class UserService {

	@Autowired
    public UserRepo repo;
	
	public User createUsersPremium(UserDto dto) {
		User user=new User();
		
		user.setFirstName(dto.getFirstName());
		user.setLastName(dto.getLastName());
		user.setMoNum(dto.getMoNum());
		user.setAge(dto.getAge());
		return  repo.save(user);
	}
	public List<User> getAllUsers() {
		return repo.findAll();
	}
	public  User getUserById(Long id) {
		return repo.findById(id).orElseThrow(()->new UserNotFoundException("user not found with this id>> "+id));
	}
	public String deleteUserById(Long id) {
		User userid=repo.findById(id).orElseThrow(()->new UserNotFoundException("user not found with this id>> "+id));
		repo.delete(userid);
		 return "user is deleted having id is" +id;
	}
	public User UpdateUser(Long id, UserDto dto) {
		User user= repo.findById(id).orElseThrow(()->new UserNotFoundException("user not found with this id>> "+id));
		user.setFirstName(dto.getFirstName());
		user.setLastName(dto.getLastName());
		user.setMoNum(dto.getMoNum());
		user.setAge(dto.getAge());
		return repo.save(user);
	}
	public User modifyUser(Long id, UserDto dto) {
		User user= repo.findById(id).orElseThrow(()->new UserNotFoundException("user not found with this id>> "+id));
		user.setFirstName(dto.getFirstName());
		user.setLastName(dto.getLastName());
		user.setMoNum(dto.getMoNum());
		user.setAge(dto.getAge());
		return repo.save(user);
	}
}
