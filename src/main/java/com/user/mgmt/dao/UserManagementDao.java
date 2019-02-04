package com.user.mgmt.dao;

import java.util.List;

import com.user.mgmt.model.User;

public interface UserManagementDao {

	public List<User> getUserList();
	
	public User saveUser(User user);
	
	public boolean deleteUser(int id);
}
