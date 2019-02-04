package com.user.mgmt.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.user.mgmt.model.User;

public interface UserManagementService {

	public List<User> getUserList();
	
	public User saveUser(User user);
	
	public boolean deleteUser(int id);
	
}
