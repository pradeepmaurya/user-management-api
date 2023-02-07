package com.user.management.management;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.user.management.users.User;

@Component
public class ManagementService {
	public static ArrayList<User> list = new ArrayList<>();
	static {
		list.add(new User(1, "prdaep", "pradeep@user", "Lucknow Uttar Pradesh", "76726372"));
		list.add(new User(2, "Mohan", "mohan@user", "Noida Uttar Pradesh", "0983793"));
		list.add(new User(3, "Aman", "aman@user", "Delhi ", "78792392"));
	}
	
	//Getting Single user Information by ID
	public User getUser(int id) {
		for(User user:list) {
			if(user.getUserId() == id) {
				return user;
			}
		}
		return null;
	}
	
	
	//Getting all users list
	public List<User> getAllUser(){
		return list;
	}
	
	//Adding user as Object of list
	public void addUser(User data) {
		try{
			list.add(data);
			System.out.println("Added Sucesfully");
		}catch(Exception e){
			System.out.println(e);
		}
	}
	
	//Updating User Details
	public User updatingUserData(int id, User data) {
		for(User user:list) {
			if(user.getUserId() == id) {
				user.setName(data.getName());
				user.setPhoneNumber(data.getPhoneNumber());
				user.setAddress(data.getAddress());
				user.setUserId(data.getUserId());
				user.setUserName(data.getUserName());
				return user;
			}
		}
		return null;
	}
	
	//Deleting User data
	public boolean deleteUserData(int id) {
		for(User user:list) {
			if(user.getUserId() == id) {
				list.remove(user);
				return true;
			}
			
		}
		return false;
	}
}