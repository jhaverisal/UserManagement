package com.example.management.service;

import com.example.management.model.Group;

public interface GroupService {

	public Group findById(Integer id);
	
	public String deleteGroupById(Integer id);
}
