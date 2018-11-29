package com.example.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.management.model.User;
import com.example.management.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {


		private UserService userService;

		@Autowired
		public UserController(UserService userService) {
			
			this.userService = userService;
		}
		
		@RequestMapping("/list")
		public List<User> listUser(){
			return userService.userList();
		}
		
		
		@RequestMapping("/find/{id}")
		public User findUser(@PathVariable Integer id){
			return userService.findById(id);
			
		}	
			
		@PostMapping("/add")
		public User addUser(@RequestBody User user) {
			return userService.addUser(user);
		}
		
		@PostMapping("/delete/{id}")
		public String deleteUser(@PathVariable Integer id) {
			return userService.deleteUserById(id);
		}
		
		@PostMapping("/assign/{uid}/{gid}")
		public void assignUserToGroup(@PathVariable Integer uid,@PathVariable Integer gid) {
			//return 
					userService.assignUserToGroup(uid,gid);
		}
		
		@PostMapping("/unassign/{uid}/{gid}")
		public User unassignUserToGroup(@PathVariable Integer uid,@PathVariable Integer gid) {
			return userService.unassignUserToGroup(uid,gid);
		}
		
		
}
