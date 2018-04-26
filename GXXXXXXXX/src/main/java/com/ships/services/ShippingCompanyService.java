package com.ships.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ships.model.Ship;
import com.ships.model.ShippingCompany;
import com.ships.repositories.ShippingCompanyRepo;

@Service 
public class ShippingCompanyService {
	
	@Autowired
	private ShippingCompanyRepo companyRepo;

	public ArrayList<ShippingCompany> findAll(){
		return (ArrayList<ShippingCompany>) companyRepo.findAll();
	}

	public ShippingCompany save(ShippingCompany ship) {
		return companyRepo.save(ship);
	}
	

}
