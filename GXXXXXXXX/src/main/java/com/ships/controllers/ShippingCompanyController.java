package com.ships.controllers;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ships.model.ShippingCompany;
import com.ships.services.ShippingCompanyService;

@Controller
public class ShippingCompanyController {
	
	// Variables
	@Autowired
	private ShippingCompanyService shipCompanyService;
	
	@RequestMapping(value = "/showShippingCompanies", method=RequestMethod.GET)
	public String getShipsC(Model m){

		ArrayList<ShippingCompany> shippingCompany = shipCompanyService.findAll();
		m.addAttribute("shipC", shippingCompany);

		return "showShippingCompanies";
	}
	
	@RequestMapping(value = "/addShippingCompany", method=RequestMethod.GET)
	public String getShip(@ModelAttribute("ShippingCompany") ShippingCompany ship){

		return "addShippingCompany";
	}

	@RequestMapping(value = "/addShippingCompany", method=RequestMethod.POST)
	public String postShip(@Valid @ModelAttribute("ShippingCompany") ShippingCompany ship, BindingResult result){

		if(result.hasErrors()){
			return "addShippingCompany";
		}else {

			shipCompanyService.save(ship);

			return "redirect:showShippingCompanies";

		}
	}
} 

