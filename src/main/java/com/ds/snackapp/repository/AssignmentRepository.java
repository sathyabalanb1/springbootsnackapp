package com.ds.snackapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ds.snackapp.entity.Assignment;

public interface AssignmentRepository extends JpaRepository<Assignment,Integer> {
	
	public List<Assignment> findByAssigneddate(String assigneddate);

}
