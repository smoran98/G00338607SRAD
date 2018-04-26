package com.ships.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ships.model.OrderInfo;
import com.ships.services.OrderService;
@Controller
public class ShippingOrderController {

	@Autowired
	private OrderService orderService;
	
	@RequestMapping(value = "/showOrders", method=RequestMethod.GET)
	public String getShipCo(Model m){

		ArrayList<OrderInfo> orderInfo = orderService.findAll();
		m.addAttribute("shipO", orderInfo);

		return "showShippingCompanies";
	}

}
