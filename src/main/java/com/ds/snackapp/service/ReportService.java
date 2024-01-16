package com.ds.snackapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ds.snackapp.entity.Dsusers;
import com.ds.snackapp.entity.Selection;
import com.ds.snackapp.repository.DsuserRepository;
import com.ds.snackapp.repository.ReportRepository;

@Service
public class ReportService {
	
	@Autowired
	private ReportRepository reportrepository;
	
	@Autowired
	private DsuserRepository userrepository;
	
	public String fetchSelectionReport(String inputdate)
	{
		String output = "";
		
		
		
		return null;
		
	}
	
	public String fetchNoAssignmentReport(String inputdate)
	{
		String output = "";
		
		output += "<p style=color:red;>No Assignment Found for the Submitted Date</p><br>";
		
		
		
		return output;
	}
	
	public String formatStartDate(String startdate) {
		String[] charArray = startdate.split("-");
		StringBuilder formattedArray = new StringBuilder();
		for (int i = charArray.length - 1; i >= 0; i--) {
			formattedArray.append(charArray[i]);
			if (i >= 1) {
				formattedArray.append("-");
			}
		}
		formattedArray.append(" 00:00:00");	
		return formattedArray.toString();
	}
	
	public String formatEndDate(String date) {
		String[] charArray = date.split("-");
		StringBuilder formattedArray = new StringBuilder();
		for (int i = charArray.length - 1; i >= 0; i--) {
			formattedArray.append(charArray[i]);
			if (i >= 1) {
				formattedArray.append("-");
			}
		}
		formattedArray.append(" 23:59:59");	
		return formattedArray.toString();
	}
	
	public List<Selection> fetchSelectionDetails(String sdate,String edate)
	{
		List<Selection>sl = reportrepository.findBySelection(sdate,edate);
		
		return sl;
	 }
	public String formatNoResponseDate(String sldate)
	{
		String[] charArray = sldate.split("-");
		StringBuilder formattedArray = new StringBuilder();
		for (int i = charArray.length - 1; i >= 0; i--) {
			formattedArray.append(charArray[i]);
			if (i >= 1) {
				formattedArray.append("-");
			}
		}
		return formattedArray.toString();

	}
	
	public List<Dsusers> fetchAllUsers()
	{
		List<Dsusers>uss = userrepository.findAll();
		
		return uss;
	}
	public List<Dsusers> pickNoResponseDetails(List<Selection>slusers,List<Dsusers>allusers)
	{
		int i=0,j=0,count=0;
		
		if(slusers.size() == 0)
		{
			List<Dsusers>xul = new ArrayList<Dsusers>();
			Dsusers u = new Dsusers();
			xul.add(u);
			return xul;
		}
				
		int allUserIds[] = pickUserIds(allusers);
		int slUserIds[] = pickSelectedUserIds(slusers);
		
		
		List<Dsusers>ul = pickNoResponseUsers(slUserIds,allusers);
		
		return ul;
		
				
	}
	public int[] pickUserIds(List<Dsusers>allusers)
	{
		int allusersize=allusers.size();
		
		int allUsersId[]= new int[allusersize];
		
		int start=0;
		int index=0;
		while(start<allusersize)
		{
			int userid=allusers.get(start).getId();
			allUsersId[index]=userid;
			start++;
			index++;
		}
		
		return allUsersId;
		
	}
	public int[] pickSelectedUserIds(List<Selection>slusers)
	{
		int slusersize=slusers.size();
		
		int slUsersId[]= new int[slusersize];
		
		int start=0;
		int index=0;
		while(start<slusersize)
		{
			int userid=slusers.get(start).getDsuser().getId();
			slUsersId[index]=userid;
			start++;
			index++;
		}
		
		return slUsersId;
		
	}
	
	public boolean linearSearch(int slUserIds[],int userid )
	{
		int i=0;
		
		while(i<slUserIds.length)
		{
			if(userid == slUserIds[i])
			{
				return true;
			}
			i++;
		}
		return false;
	}
	public List<Dsusers> pickNoResponseUsers(int slUserIds[],List<Dsusers>allusers)
	{
		List<Dsusers>ul = new ArrayList<Dsusers>();
		
		
		int i=0;
		
		while(i<allusers.size())
		{
			if(linearSearch(slUserIds,allusers.get(i).getId()))
			{
				i++;
			}
			else
			{
				ul.add(allusers.get(i));
				i++;
			}
		}
		List<Dsusers>xxx=ul;
		return ul;

	}
	

}
