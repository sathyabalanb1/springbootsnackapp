package com.ds.snackapp.service;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.ds.snackapp.entity.Assignment;
import com.ds.snackapp.entity.Dsusers;
import com.ds.snackapp.entity.Selection;
import com.ds.snackapp.repository.SelectionRepository;

@Service
public class SelectionService {
	@Autowired
	private SelectionRepository selectionrepository;
	
	@Autowired
	private ReportService reportservice;
		
	
	public Selection addSelection(Selection selectiondetails)
	{
		return selectionrepository.save(selectiondetails);
	}
	
	public Selection fetchSelectionDetails(int assignmentid, int userid)
	{
		Selection sl = selectionrepository.findUserselection(assignmentid,userid);
		//System.err.println(sl);
		
		
		return sl;
	}
	public Selection updateSelection(Selection existingselection,Selection selectiondetails)
	{
		existingselection.setEnabled(selectiondetails.isEnabled());
		
		return selectionrepository.save(existingselection);
		
	}
	
	public ModelAndView redirectToHomepage(int roleid)
	{
		if(roleid == 1 || roleid == 2)
		{
			return new ModelAndView("redirect:/admin/adminhomepage");
		}
		else
		{
			return new ModelAndView("redirect:/userhomepage");
		}
	}
	
	
	/*
	public int fetchYesSelectedEmployees()
	{
		Date date = new Date();
		String inputdate = new SimpleDateFormat("dd-MM-yyyy").format(date);
		
		String startdate = reportservice.formatStartDate(inputdate);
		String enddate = reportservice.formatEndDate(inputdate);
		
		int yescount = selectionrepository.fetchYesSelection(startdate,enddate);
		
		int nocount = selectionrepository.fetchNoSelection(startdate,enddate);
		
		int noresponsecount = selectionrepository.fetchNoResponse(startdate,enddate);
		
		int sum = nocount;
		
		return 5;
	}
	*/
	public Map fetchSelectionCount()
	{
		Date date = new Date();
		String inputdate = new SimpleDateFormat("dd-MM-yyyy").format(date);
		
		String startdate = reportservice.formatStartDate(inputdate);
		String enddate = reportservice.formatEndDate(inputdate);
		
		int yescount = selectionrepository.fetchYesSelection(startdate,enddate);
		
		int nocount = selectionrepository.fetchNoSelection(startdate,enddate);
		
		int noresponsecount = selectionrepository.fetchNoResponse(startdate,enddate);
		
		Map<String,Integer>mm = new HashMap<String,Integer>();
		
		mm.put("yescount", yescount);
		mm.put("nocount", nocount);
		mm.put("noresponsecount", noresponsecount);
		
		return mm;
	}
	
	public boolean checkSelectionTime()
	{
        ZoneId zoneId = ZoneId.of("Asia/Kolkata");
        
        ZonedDateTime currentDateTime = ZonedDateTime.now(zoneId);
        
        LocalDateTime now = LocalDateTime.now();
        long currentmilliseconds = now.atZone(ZoneOffset.UTC).toInstant().toEpochMilli();
        
        LocalDateTime predefinedTime = LocalDateTime.of(
                currentDateTime.toLocalDate(),  // Today's date
                LocalTime.of(19, 30, 00)              // 6:30 PM
        );
        
        long predefinedmilliseconds = predefinedTime.atZone(ZoneOffset.UTC).toInstant().toEpochMilli();
        
        if(currentmilliseconds>predefinedmilliseconds)
        {
        	return false;
        }
        
        return true;

	}
	
	public ModelAndView displayChooseSnackTimeInfo(boolean ans,String empname)
	{
		ModelAndView model = new ModelAndView();
		
		if(ans == false)
		{
			model.addObject("empname", empname);
			model.addObject("selectiontimeerror","Time is Over to Choose the Snack");
			model.addObject("selectiontimeinfo","Please choose the snack before 1:30 PM");
			model.setViewName("/snackselection/Editsnackselectionform.jsp");
			return model;
		}
		
		return model;
	}
	
	public ModelAndView displaySnackSelectionInfo(Selection sl)
	{
		ModelAndView model = new ModelAndView();
		
		boolean val = sl.isEnabled();
		
		String temp;
		
		if(val == true)
		{
			temp="Yes";
		}
		else
		{
			temp="No";
		}
		
		String empname = sl.getDsuser().getName();
		
		model.addObject("empname", empname);
		model.addObject("selectionvalue", temp);
		model.setViewName("/snackselection/Snackselectionform.jsp");
		return model;
	}
	

}
