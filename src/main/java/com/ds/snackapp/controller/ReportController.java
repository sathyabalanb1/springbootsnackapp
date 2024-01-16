package com.ds.snackapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ds.snackapp.entity.Dsusers;
import com.ds.snackapp.entity.Selection;
import com.ds.snackapp.service.AssignmentService;
import com.ds.snackapp.service.ReportService;

@Controller
public class ReportController {

	@Autowired
	AssignmentService assignmentservice;

	@Autowired
	ReportService reportservice;
	/*
	@GetMapping("/preparereport")
	public String prepareSelectionReport(@RequestParam("reportdate") String rd)
	{
		// String xx = rd;
		//ModelAndView model = new ModelAndView();
		int assignmentcount = assignmentservice.isValidDate(rd);

		if(assignmentcount>0)
		{
			return reportservice.fetchSelectionReport(rd);
		//	return;
		}
		else
		{
		  return  reportservice.fetchNoAssignmentReport(rd);
		//  model.addObject("noassreport", noassreport);
		//  model.setViewName("report/Reportpage.jsp");
		 // return;
		}
	}
	 */

	@GetMapping("/preparereport")
	public ResponseEntity<List<Selection>> prepareSelectionReport(@RequestParam("input") String inputdate)
	{

	//	String dateArray[] = inputdate.split(" - ");
		

		String sd = reportservice.formatStartDate(inputdate);
		String ed = reportservice.formatEndDate(inputdate);	

		List<Selection>s = reportservice.fetchSelectionDetails(sd,ed);
		
		return new ResponseEntity<>(s, HttpStatus.OK);

		/*
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startdate);


		try {
            SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd");
            System.out.println(inputFormat.getCalendar());
            Date sdate = inputFormat.parse(startdate);
            Date edate = inputFormat.parse(enddate);

            SimpleDateFormat soutputFormat = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
            String formattedStartDate = soutputFormat.format(sdate);

            SimpleDateFormat eoutputFormat = new SimpleDateFormat("yyyy-MM-dd 23:59:59");
            String formattedEndDate = eoutputFormat.format(edate);
            System.out.println(sdate);
            System.out.println(edate);
            System.out.println("Formatted Date: " + formattedStartDate);
            System.out.println("Formatted Date: " + formattedEndDate);

	        } catch (ParseException e) {
	            e.printStackTrace();
	        }
		 */


	}

	/*
	@GetMapping("/preparenoresponsereport")
	public void prepareNoResponseReport(@RequestParam("input") String inputdate)
	{
		String dateArray[] = inputdate.split(" - ");

		String sd = reportservice.formatNoResponseDate(dateArray[0]);

		reportservice.fetchNoResponseDetails(sd);
	}
	*/
	
	
	@GetMapping("/preparenoresponsereport")
	public ResponseEntity<List<Dsusers>> prepareNoResponseReport(@RequestParam("input") String inputdate)
	{
		String sd = reportservice.formatStartDate(inputdate);
		String ed = reportservice.formatEndDate(inputdate);	
		
		List<Selection>sllist = reportservice.fetchSelectionDetails(sd,ed);
		
		List<Dsusers>dusers = reportservice.fetchAllUsers();
		
		List<Dsusers>noresponseusers = reportservice.pickNoResponseDetails(sllist,dusers);

		//List<Dsusers>output = reportservice.pickNoResponseDetails(sllist,dusers);
		
		return new ResponseEntity<>(noresponseusers, HttpStatus.OK);
	}
	
	


}
