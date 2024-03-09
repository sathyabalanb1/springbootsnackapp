package com.ds.snackapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.ds.snackapp.entity.Dsusers;



public interface DsuserRepository extends JpaRepository<Dsusers, Integer> {
	
	public Dsusers findByEmail(String emaill);
	
	@Query("UPDATE Dsusers u SET u.failedAttempt = ?1 WHERE u.email = ?2")
	@Modifying
	public void updateFailedAttempts(int failAttempts, String email);

}
