package com.ds.snackapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.ds.snackapp.dto.AssignmentDTO;
import com.ds.snackapp.entity.Assignment;
import com.ds.snackapp.repository.AssignmentRepository;
import com.ds.snackapp.repository.SnackRepository;
import com.ds.snackapp.repository.VendorRepository;

@Service
public class AssignmentService {
	@Autowired
	private AssignmentRepository assignmentrepository;

	@Autowired
	private SnackRepository snackrepository;

	@Autowired
	private VendorRepository vendorrepository;

	public String createAssignment(AssignmentDTO assignment, String date){
		
		List<Assignment>ass = assignmentrepository.findByAssigneddate(date);
		if(ass.size()>0)
		{
			return null;
		}
		else
		{
		Assignment assign = new Assignment();
		assign.setAssigneddate(date);
		assign.setSnack(snackrepository.getById(assignment.getSnacksId()));
		assign.setVendor(vendorrepository.getById(assignment.getVendorId()));
		assignmentrepository.save(assign);
		return "Snack is Assigned Successfully";
		}
	}
/*
	public List<Assignment> getAssignments()
	{
		List<Assignment>asmts = assignmentrepository.findAll();
		
		List<Assignment>resultasmts = new ArrayList<Assignment>();
		
		int i=0;
		
		while(i<asmts.size())
		{
			Assignment obj = asmts.get(i);
			
			int snackid = obj.getSnack().getId();
			
			int vendorid = obj.getVendor().getId();
			
		//	 snackrepository.findById(snackid).get(0);
			
			String snackname = snackrepository.findSnackname(snackid);
			
			String vendorname = vendorrepository.findVendorname(vendorid);
			
			Assignment result = new Assignment();
			
			result.setAssigneddate(asmts.get(i).getAssigneddate());
			result.
			
			
			
			
			
			
		}
	}
	*/
	public List<Assignment> getAssignments()
	{
	//	Assignment ass = assignmentrepository.findById(1).orElse(null);
	//	System.out.println(ass.getVendor().getVendorname());

		List<Assignment>ass = assignmentrepository.findAll();
	
		return ass;
	}
	public String getAssignmentById(int assignmentid)
	{
		Assignment ass = assignmentrepository.getById(assignmentid);
		String snackname = ass.getSnack().getSnackname();
		return snackname;
	}
	public Assignment editAssignment(int snackid, int vendorid, int assignmentid)
	{
		Assignment existingAssignment = assignmentrepository.findById(assignmentid).orElse(null);
		
		existingAssignment.setSnack(snackrepository.getById(snackid));
		existingAssignment.setVendor(vendorrepository.getById(vendorid));
		
		return assignmentrepository.save(existingAssignment);
		
	}
	public String removeAssignment(int assignmentid)
	{
		assignmentrepository.deleteById(assignmentid);
		return "Assignment is Removed";
	}

}
