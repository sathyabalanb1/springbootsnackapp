package com.ds.snackapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ds.snackapp.entity.Snack;
import com.ds.snackapp.entity.Vendor;
import com.ds.snackapp.repository.VendorRepository;

@Service
public class VendorService {
	@Autowired
	VendorRepository vendorrepository;
	
	public Vendor createVendor(Vendor vendor)
	{
		return vendorrepository.save(vendor);
	}
	public List<Vendor> getVendors()
	{
		return vendorrepository.findAll();
	}
	public Vendor getVendorById(int id)
	{
		return  vendorrepository.findById(id).orElse(null);
	}
	public Vendor updateVendor(Vendor vendor)
	{
		int vendorid = vendor.getId();
		
        Vendor existingvendor= vendorrepository.findById(vendor.getId()).orElse(null);
        
        existingvendor.setVendorname(vendor.getVendorname());
        existingvendor.setCity(vendor.getCity());
        existingvendor.setState(vendor.getState());
        existingvendor.setCountry(vendor.getCountry());
        existingvendor.setPincode(vendor.getPincode());
        existingvendor.setMobilenumber(vendor.getMobilenumber());
        existingvendor.setLandlinenumber(vendor.getLandlinenumber());
        existingvendor.setEmail(vendor.getEmail());

		return vendorrepository.save(existingvendor);
	}
	public String deleteVendor(int id)
	{
		vendorrepository.deleteById(id);
		return "Vendor is Removed";
	}
}
