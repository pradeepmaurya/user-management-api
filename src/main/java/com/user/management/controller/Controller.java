package com.user.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.user.management.management.ManagementService;
import com.user.management.users.User;

@RestController
public class Controller {
	
	@Autowired
	public ManagementService service;

	//Getting Single User by ID 
	@GetMapping("/getUser/{id}")
	public User getUserById(@PathVariable("id") int id) {
		if(service.getUser(id) != null) {
			return service.getUser(id);
		}else {
			return null;
		}
	}
	
	//Getting All Users Information Method
	@GetMapping("/getAllUser")
	public List<User> getAllUser() {
		return service.getAllUser();
	}
	
	//Adding User Method
	@PostMapping("/addUser")
	public String addUser(@RequestBody User data) {
		try {
			service.addUser(data);
		}catch(Exception e) {
			return "Something went Wrong :"+e;
		}
		return "Succesfully Added";
	}
	
	//Updating users Data
	@PutMapping("/updateUserInfo/{id}")
	public User updateData(@RequestBody User data, @PathVariable("id") int id) {
		return this.service.updatingUserData(id, data);
	}
	
	//Deleting User data
	@DeleteMapping("/deleteUser/{id}")
	public String deleteData(@PathVariable("id") int id) {
		if(service.deleteUserData(id)) {
			return "Deleted Succesfully!";
		}else {
			return "Failled due to some reason!";
		}
	}
	
}
