package com.ships.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ships.model.OrderInfo;
import com.ships.model.Ship;
import com.ships.model.ShippingCompany;
import com.ships.services.OrderService;
import com.ships.services.ShipService;
import com.ships.services.ShippingCompanyService;
@Controller
public class ShippingOrderController {
	
	// Variables
	@Autowired
	private ShippingCompanyService ShippingCompanyService;
	@Autowired
	private ShipService shipService;
	@Autowired
	private OrderService orderInfoService;
	
	// Handles Errors
	@ExceptionHandler(value = Exception.class)
	public String handleError() {
		return "errorCreateOrder";
	}
	
	// Method shows all ships orders
	@RequestMapping(value = "/showOrders", method=RequestMethod.GET)
	public String getOrders(Model m){

		ArrayList<OrderInfo> ships = (ArrayList<OrderInfo>) orderInfoService.findAll();

		m.addAttribute("shipO", ships);

		return "showOrders";
	}
	// Returns createOrder
	@RequestMapping(value = "/createOrder", method=RequestMethod.GET)
	public String AddOrder(Model model) {

		ArrayList<Ship> AllShips = (ArrayList<Ship>) shipService.findShips();		
		ArrayList<ShippingCompany> companies = (ArrayList<ShippingCompany>) ShippingCompanyService.findAll();
		
		Map<Long,String> shipMap = new HashMap<Long,String>();
		for (Ship ship : AllShips) {
			if(ship.getShippingCompany() == null) {
				shipMap.put((long) ship.getSid(), ship.getName() + ";" + " Cost= " + ship.getCost());		
			}
		}
		model.addAttribute("shipList", shipMap);

		Map<Long,String> companyMap = new HashMap<Long,String>();
		for (ShippingCompany company : companies) {
			companyMap.put((long) company.getScid(), company.getName() + ";" + " Balance= " +company.getBalance());
		}

		model.addAttribute("companyList", companyMap);

		OrderInfo order = new OrderInfo();
		model.addAttribute("orderInfo", order);

		return "createOrder";
	}

	// Saves order details
	@RequestMapping(value = "/createOrder", method=RequestMethod.POST)
	public String PostOrder(@Valid @ModelAttribute("orderInfo") OrderInfo order, BindingResult result) {
		if(result.hasErrors()) {			
			return "createOrder";
		}
		else{
			orderInfoService.save(order);
			return "redirect:showOrders";
		}
	}

}
