package com.ships.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ships.model.Ship;
import com.ships.repositories.ShipRepository;

@Service
public class ShipService {
	
	@Autowired
	private ShipRepository shipRepo;
	
	// Method for ships dbase
	public ArrayList<Ship> findShips() {
		return(ArrayList<Ship>) shipRepo.findAll();
	}
	
	public Ship save(Ship ship) {
		return shipRepo.save(ship);
	}

}
