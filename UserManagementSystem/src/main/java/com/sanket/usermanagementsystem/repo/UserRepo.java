package com.sanket.usermanagementsystem.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.sanket.usermanagementsystem.entity.User;


@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
	
	
	public User getUserByUsername(String username);
	
	public User getPasswordByUsername(String username); 
	

	

}
