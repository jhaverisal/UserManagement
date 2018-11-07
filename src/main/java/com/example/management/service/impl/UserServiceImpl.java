package com.example.management.service.impl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.management.exception.ResourceNotFoundException;
import com.example.management.model.Group;
import com.example.management.model.User;
import com.example.management.repository.UserRepository;
import com.example.management.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;
	
	@Autowired
	GroupServiceImpl grpService;
	
	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
}

	
	@Override
	public List<User> userList() {
		return userRepository.findAll();
	}

	@Override
	public User findById(Integer id) {
		Optional<User> u= userRepository.findById(id);
		if(u.isPresent())
			return u.get();
		else 
			throw new ResourceNotFoundException(id,"The user does not exist");
		
	}

	@Override
	public User addUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public String deleteUserById(Integer id) {
		userRepository.deleteById(id);
		 return "{message : User deleted successfully}";
	}

	@Override
	public void updateUserById(Integer id) {
		// TODO Auto-generated method stub
		//userRepository.

	}
	
	@Override
	public void assignUserToGroup(int uid,int gid) {
		User user=findById(uid);
		
		Group grp=grpService.findById(gid);
		user.getGroups().add(grp);
		userRepository.save(user);
		//return user;
	}
	
	@Override
	public User unassignUserToGroup(int uid,int gid) {
		User user=findById(uid);
		
		Group grp=grpService.findById(gid);
				//entityManager.getReference(Group.class,gid);
			
		user.getGroups().remove(grp);
		userRepository.save(user);
		
		
		
		return user;
	}

}
