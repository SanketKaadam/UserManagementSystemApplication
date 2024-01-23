package com.sanket.usermanagementsystem.service;

import java.util.List; 
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sanket.usermanagementsystem.Mapper.UserMapper;
import com.sanket.usermanagementsystem.dto.UserDTO;
import com.sanket.usermanagementsystem.entity.User;
import com.sanket.usermanagementsystem.repo.UserRepo;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepo repo;

	@Override
	public User saveUser(User user) {
		
		User savedUser = repo.save(user);
		return savedUser;
	}

	@Override
	public List<User> fetchAllUser() {
		List<User> userList = repo.findAll();
		return userList;
	}

	@Override
	public Object getUserByUsername(String username) {
		
		User user = repo.getUserByUsername(username);
		
		return user;
	}

	@Override
	public User updateUser(User user) {
		User updatedUser = repo.save(user);
		return updatedUser;
	}



	







}
