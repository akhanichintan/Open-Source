package com.user.mgmt.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.user.mgmt.model.User;
import com.user.mgmt.service.UserManagementService;

/**
 * 
 * @author Chintan Akhani
 *
 * This controller handles user management related requests.
 */

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class UserManagementController {

	
	@Autowired
	UserManagementService userMgmtService;
	
	Logger _log = LoggerFactory.getLogger(UserManagementController.class);
	/**
	 * 
	 * @return List<User>
	 */
	@RequestMapping(value = "/getUsers", method = RequestMethod.GET)
	public List<User> getUserList () {
		
		List<User> users = userMgmtService.getUserList();
		if (_log.isDebugEnabled()) {
			if (users != null) {
				_log.debug("Total Users : "+ userMgmtService.getUserList().size());
			} else {
				_log.debug("User list is empty.");
			}
			
		}
		
		return userMgmtService.getUserList();
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public User saveUser(@RequestBody User user) {
		
		return userMgmtService.saveUser(user);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable("id") int id) {
		_log.info("Delete User Profile ::::");
		boolean isDeleted = userMgmtService.deleteUser(id);
		ResponseEntity<String> response = null;
		if (isDeleted) {
			response = new ResponseEntity("User has been deleted!", HttpStatus.OK);
		} else {
			response = new ResponseEntity("User has not been deleted!", HttpStatus.NOT_FOUND);
		}
		return response;
	}
}
