package com.ships.services;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ships.model.OrderInfo;
import com.ships.model.Ship;
import com.ships.model.ShippingCompany;
import com.ships.repositories.ShipRepository;
import com.ships.repositories.ShippingCompanyRepo;
import com.ships.repositories.ShippingOrderRepo;

@Service
public class OrderService {
	@Autowired
	private ShippingOrderRepo orderInfoInterface;
	@Autowired
	private ShippingCompanyRepo shippingCompanyRepo;
	@Autowired
	private ShipRepository shipRepository;
	
	private Ship ship;
	private ShippingCompany shippingCompany;
	
	DateTimeFormatter date = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	LocalDate localDate = LocalDate.now();

	// Method for ships dbase
	public ArrayList<OrderInfo> findAll() {
		return(ArrayList<OrderInfo>) orderInfoInterface.findAll();
	}
	//saves order 
	public OrderInfo save(OrderInfo order) {
	
		order.setDate(date.format(localDate));	
		
		ship =shipRepository.findOne(order.getShip().getSid());
		shippingCompany = shippingCompanyRepo.findOne(order.getShippingCompany().getScid());
		
		ship.setShippingCompany(shippingCompany);
		shippingCompany.setBalance(shippingCompany.getBalance().subtract(ship.getCost()));

		return orderInfoInterface.save(order);
	}

}
