package com.ds.snackapp.service;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.ds.snackapp.dto.AssignmentDTO;
import com.ds.snackapp.entity.Assignment;
import com.ds.snackapp.entity.Snack;
import com.ds.snackapp.entity.Vendor;
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

	public String createAssignment(AssignmentDTO assignment, String date) {
		
		List<Assignment> ass = assignmentrepository.findByAssigneddate(date);
		if (ass.size() > 0) {
			int assignmentid = ass.get(0).getId();
			Assignment a = assignmentrepository.findById(assignmentid).orElse(null);
			a.setAssigneddate(date);
			a.setSnack(snackrepository.getById(assignment.getSnacksId()));
			a.setVendor(vendorrepository.getById(assignment.getVendorId()));
			assignmentrepository.save(a);
			return null;
		} else {
			Assignment assign = new Assignment();
			assign.setAssigneddate(date);
			assign.setSnack(snackrepository.getById(assignment.getSnacksId()));
			assign.setVendor(vendorrepository.getById(assignment.getVendorId()));
			assignmentrepository.save(assign);
			return "Snack is Assigned Successfully";
		}
	}
	
	

	/*
	 * public List<Assignment> getAssignments() { List<Assignment>asmts =
	 * assignmentrepository.findAll();
	 * 
	 * List<Assignment>resultasmts = new ArrayList<Assignment>();
	 * 
	 * int i=0;
	 * 
	 * while(i<asmts.size()) { Assignment obj = asmts.get(i);
	 * 
	 * int snackid = obj.getSnack().getId();
	 * 
	 * int vendorid = obj.getVendor().getId();
	 * 
	 * // snackrepository.findById(snackid).get(0);
	 * 
	 * String snackname = snackrepository.findSnackname(snackid);
	 * 
	 * String vendorname = vendorrepository.findVendorname(vendorid);
	 * 
	 * Assignment result = new Assignment();
	 * 
	 * result.setAssigneddate(asmts.get(i).getAssigneddate()); result.
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * } }
	 */
	public List<Assignment> getAssignments() {
		// Assignment ass = assignmentrepository.findById(1).orElse(null);
		// System.out.println(ass.getVendor().getVendorname());

	//	List<Assignment> ass = assignmentrepository.findAll();
		
		List<Assignment> ass = assignmentrepository.findAllByOrderByIdDesc();

		return ass;
	}

	public String getAssignmentById(int assignmentid) {
		Assignment ass = assignmentrepository.getById(assignmentid);
		String snackname = ass.getSnack().getSnackname();
		return snackname;
	}

	public Assignment editAssignment(int snackid, int vendorid, int assignmentid) {
		Assignment existingAssignment = assignmentrepository.findById(assignmentid).orElse(null);

		existingAssignment.setSnack(snackrepository.getById(snackid));
		existingAssignment.setVendor(vendorrepository.getById(vendorid));

		return assignmentrepository.save(existingAssignment);

	}

	public String removeAssignment(int assignmentid) {
		assignmentrepository.deleteById(assignmentid);
		return "Assignment is Removed";
	}

	public List<Assignment> getAssignmentDetails()	{

		Date date = new Date();
		String modifiedDate = new SimpleDateFormat("yyyy-MM-dd").format(date);

		List<Assignment> assments = assignmentrepository.findByAssigneddate(modifiedDate);
		return assments;
	}
	
	public List<Assignment> getAssignedSnack(int snackid)
	{
	//	Snack sn = snackrepository.getById(snackid);
		
		Snack sn = snackrepository.findById(snackid).orElse(null);
		List<Assignment> n=assignmentrepository.findBySnack(sn);
		
		int listsize = n.size();
		System.out.println(listsize);
		return n;
	}
	public int isValidDate(String reportdate)
	{
		List<Assignment> an = assignmentrepository.findByAssigneddate(reportdate);
		
		return an.size();
	}
	
	public Assignment getAssignedVendor(int vendorid)
	{
		Vendor vn = vendorrepository.getById(vendorid);
		
		return assignmentrepository.findByVendor(vn);
	}
	public String pickPresentDate()
	{
		Date date = new Date();
		String inputdate = new SimpleDateFormat("yyyy-MM-dd").format(date);
		
		return inputdate;
	}
	public ModelAndView displayNoAssignmentInfo(List<Assignment>ass,String empname)
	{
		ModelAndView model = new ModelAndView();
		
		if(ass.size() == 0)
		{
			model.addObject("empname", empname);
			model.addObject("choosesnackerror","Today's Snack is Not Yet Assigned");
			model.setViewName("/snackselection/Snackselectionform.jsp");
			return model;
		}
		return model;
	}
	public boolean checkAssignmentTime()
	{
        ZoneId zoneId = ZoneId.of("Asia/Kolkata");
        
        ZonedDateTime currentDateTime = ZonedDateTime.now(zoneId);
        
        LocalDateTime now = LocalDateTime.now();
        long currentmilliseconds = now.atZone(ZoneOffset.UTC).toInstant().toEpochMilli();
        
        LocalDateTime predefinedTime = LocalDateTime.of(
                currentDateTime.toLocalDate(),  // Today's date
                LocalTime.of(20, 30, 00)              // 6:30 PM
        );
        
        long predefinedmilliseconds = predefinedTime.atZone(ZoneOffset.UTC).toInstant().toEpochMilli();
        
        if(currentmilliseconds>predefinedmilliseconds)
        {
        	return false;
        }
        
        return true;

	}

}
