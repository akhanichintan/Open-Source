package com.user.mgmt.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.user.mgmt.model.User;

@Repository
public class UserManagementDaoImpl implements UserManagementDao {

	private static List<User> DUMMY_LIST = null;
	//TODO Remove static dummy data list and do end to end implementation
	static {
		DUMMY_LIST = new ArrayList<User>();
		User user = new User();
		user.setId(1);
		user.setFirstName("Chintan");
		user.setLastName("Akhani");
		user.setEmailAddress("akhanichintan@gmail.com");
		DUMMY_LIST.add(user);
		
		
	}
	
	@Override
	public User saveUser(User user) {
		int tempId = DUMMY_LIST.size() + 1;
		user.setId(tempId);
		DUMMY_LIST.add(user);
		return user;
	}

	@Override
	public boolean deleteUser(int id) {
		if (DUMMY_LIST.size() > 0) {
			for (int i=0; i < DUMMY_LIST.size(); i++) {
				if (DUMMY_LIST.get(i).getId() == id) {
					DUMMY_LIST.remove(i);
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public List<User> getUserList() {
		
		return DUMMY_LIST;
	}
	
	
}
