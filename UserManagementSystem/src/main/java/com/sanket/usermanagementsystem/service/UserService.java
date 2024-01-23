package com.sanket.usermanagementsystem.service;

import java.util.List; 

import org.springframework.stereotype.Service;


import com.sanket.usermanagementsystem.dto.UserDTO;
import com.sanket.usermanagementsystem.entity.User;

@Service
public interface UserService {

	User saveUser(User user);

	List<User> fetchAllUser();

	Object getUserByUsername(String username);

	User updateUser(User user);


	

	



	

}
