package com.ds.snackapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ds.snackapp.entity.Vendor;

public interface VendorRepository extends JpaRepository<Vendor,Integer>{
	
//	public String findVendorname(int vendorid);

}
