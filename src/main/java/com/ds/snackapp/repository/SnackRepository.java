package com.ds.snackapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ds.snackapp.entity.Dsusers;
import com.ds.snackapp.entity.Snack;

public interface SnackRepository extends JpaRepository<Snack,Integer> {
	
	//public String findSnackname(int snackid);

}
