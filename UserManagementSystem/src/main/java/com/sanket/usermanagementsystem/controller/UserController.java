package com.sanket.usermanagementsystem.controller;

import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sanket.usermanagementsystem.dto.LoginDTO;
import com.sanket.usermanagementsystem.dto.UserDTO;
import com.sanket.usermanagementsystem.entity.User;
import com.sanket.usermanagementsystem.service.UserService;

@RestController
@RequestMapping("/project")
public class UserController {
	
	
	@Autowired
	UserService service;
	
	
	@PostMapping("/registrationUser")
	public ResponseEntity<?> addUser(@RequestBody User user){
		
		User savedUser;
		
		String username = user.getUsername();
		
		if(service.getUserByUsername(username) != null)
		{
			return new ResponseEntity<String>("User Alredy register", HttpStatus.OK);
		}else {
			savedUser = service.saveUser(user);
		}
		
		return new ResponseEntity<User>(savedUser, HttpStatus.CREATED);
		
	}
	
	
	@GetMapping("/getAllUsers")
	public ResponseEntity<List<User>> getAllUser(){
		List<User> userList = service.fetchAllUser();
		return new ResponseEntity<List<User>>(userList, HttpStatus.OK);
	}
	
	
	@GetMapping("/login")
	public ResponseEntity<?> userLogin(@RequestBody User user){
		
       
		
		String username = user.getUsername();
		String password = user.getPassword();
		
		
		if(service.getUserByUsername(username) == null)
		{
			return new ResponseEntity<String>("Login failed! please enter correct deatils", HttpStatus.OK);
		}
		
		User fetchUserForPassword = (User) service.getUserByUsername(username);
		
		if (fetchUserForPassword.getPassword().equals(password) ) {
			
			return new ResponseEntity<String>("Successfully Login", HttpStatus.ACCEPTED);
		}else {
			return new ResponseEntity<String>("Login failed! please enter correct deatils", HttpStatus.OK);
		}
		
	}
	
	
	@PutMapping("/passwordReset")
     public ResponseEntity<?> updatePassword(@RequestBody User user){
		
	
		
		String username = user.getUsername();
		
		if(service.getUserByUsername(username) == null)
		{
			return new ResponseEntity<String>("User Not Found!", HttpStatus.NOT_FOUND);
		}else {
			 service.saveUser(user);
		}
		
		return new ResponseEntity<String>("Password Updated", HttpStatus.CREATED);
		
	}
	
	
	
	
	
	
	
	
	
	

}
