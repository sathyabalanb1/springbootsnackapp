package com.ds.snackapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ds.snackapp.entity.Dsusers;



public interface DsuserRepository extends JpaRepository<Dsusers, Integer> {
	
	public List<Dsusers> findByEmail(String username);

}
