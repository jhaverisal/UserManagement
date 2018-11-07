package com.example.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.management.model.Group;
import com.example.management.service.GroupService;

@RestController
@RequestMapping("/group")
public class GroupController {
	
	@Autowired
	private GroupService groupService;
	
	@RequestMapping("find/{id}")
	public Group findById(@PathVariable Integer id) {
		return groupService.findById(id);
	}
	
	@PostMapping("delete/{id}")
	public String deleteById(@PathVariable Integer id) {
		return groupService.deleteGroupById(id);
	}
	

}
