package com.example.management.service;

import java.util.List;

import com.example.management.model.User;

public interface UserService {
	
	public List<User> userList();
	
	public User findById(Integer id);
	
	public User addUser(User user);
	
	public String deleteUserById(Integer id);
	
	public void updateUserById(Integer id);
	
	public void assignUserToGroup(int uid,int gid) ;
	
	public User unassignUserToGroup(int uid,int gid);
	
	

}
