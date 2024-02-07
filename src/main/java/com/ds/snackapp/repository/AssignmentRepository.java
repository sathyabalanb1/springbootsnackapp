package com.ds.snackapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ds.snackapp.entity.Assignment;
import com.ds.snackapp.entity.Snack;
import com.ds.snackapp.entity.Vendor;

public interface AssignmentRepository extends JpaRepository<Assignment,Integer> {
	
	public List<Assignment> findByAssigneddate(String assigneddate);
	
	public List<Assignment> findBySnack(Snack snackid);
	
	public Assignment findByVendor(Vendor vn);
	
	public List<Assignment> findAllByOrderByIdDesc();

}
