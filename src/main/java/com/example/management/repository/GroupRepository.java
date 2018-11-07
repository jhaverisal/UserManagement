package com.example.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.management.model.Group;

public interface GroupRepository extends JpaRepository<Group, Integer> {

}
