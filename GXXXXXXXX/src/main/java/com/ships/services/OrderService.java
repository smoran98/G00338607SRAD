package com.ships.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.ships.model.OrderInfo;
import com.ships.repositories.ShippingOrderRepo;

@Service
public class OrderService {
	
	private ShippingOrderRepo orderInfoInterface;

	public ArrayList<OrderInfo> findAll() {	
		return (ArrayList<OrderInfo>) orderInfoInterface.findAll();	
	}

}
