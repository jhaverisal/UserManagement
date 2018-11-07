package com.example.management.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.management.exception.ResourceNotFoundException;
import com.example.management.model.Group;
import com.example.management.model.User;
import com.example.management.repository.GroupRepository;
import com.example.management.service.GroupService;

@Service
public class GroupServiceImpl implements GroupService {
	
	@Autowired
	private GroupRepository groupRepository;
	
	@Override
	public Group findById(Integer id) {
		Optional<Group> g= groupRepository.findById(id);
		if(g.isPresent())
			return g.get();
		else 
			throw new ResourceNotFoundException(id,"The group does not exist");
		
	}

	@Override
	public String deleteGroupById(Integer id) {
		groupRepository.deleteById(id);
		 return "{message : group deleted successfully}";
	}

}
