package com.ds.snackapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ds.snackapp.entity.Dsusers;



public interface DsuserRepository extends JpaRepository<Dsusers, Integer> {
	
	public Dsusers findByEmail(String emaill);

}
