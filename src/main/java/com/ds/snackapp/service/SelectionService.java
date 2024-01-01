package com.ds.snackapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ds.snackapp.entity.Selection;
import com.ds.snackapp.repository.SelectionRepository;

@Service
public class SelectionService {
	@Autowired
	private SelectionRepository selectionrepository;
	
	public Selection addSelection(Selection selectiondetails)
	{
		return selectionrepository.save(selectiondetails);
	}

}
