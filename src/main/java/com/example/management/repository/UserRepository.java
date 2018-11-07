package com.example.management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.management.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	//public List<User> findByUserName(String uname);
}
