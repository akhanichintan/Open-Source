package com.user.mgmt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.mgmt.dao.UserManagementDao;
import com.user.mgmt.model.User;

/**
 * @author Chintan Akhani
 * 
 */
@Service
public class UserManagementServiceImpl implements UserManagementService {
	
	@Autowired
	UserManagementDao userManagementDao;
	
	/**
	 * Get list of users
	 */
	@Override
	public List<User> getUserList() {
		return userManagementDao.getUserList();
	}
	
	@Override
	public User saveUser(User user) {
		return userManagementDao.saveUser(user);
	}

	@Override
	public boolean deleteUser(int id) {
		return userManagementDao.deleteUser(id);
	}
	
	
	
	

}
