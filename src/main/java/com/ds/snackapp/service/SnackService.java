package com.ds.snackapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ds.snackapp.entity.Snack;
import com.ds.snackapp.repository.SnackRepository;

@Service
public class SnackService {
	@Autowired
	private SnackRepository snackrepository;
	
	public Snack createSnack(Snack snack)
	{
		return snackrepository.save(snack);
	}
	public List<Snack> createSnacks(List<Snack>snacks)
	{
		return snackrepository.saveAll(snacks);
	}
	public List<Snack> getSnacks()
	{
		return snackrepository.findAll();
	}
	public Snack getSnackById(int id)
	{
		return snackrepository.findById(id).orElse(null);		
	}
	public Snack updateSnack(Snack snack)
	{
		int snackid = snack.getId();
		
        Snack existingsnack= snackrepository.findById(snack.getId()).orElse(null);
        
        existingsnack.setSnackname(snack.getSnackname());
		
		return snackrepository.save(existingsnack);
	}
	public String deleteSnack(int id)
	{
		snackrepository.deleteById(id);
		return "Snack is Removed";
	}
	
}
