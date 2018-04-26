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

import com.ships.model.Ship;
import com.ships.services.ShipService;

@Controller
public class ShipController {

	@Autowired
	private ShipService shipService;

	@RequestMapping(value = "/showShips", method=RequestMethod.GET)
	//(Model m (m for model)
	public String getShips(Model m){

		ArrayList<Ship> ships = (ArrayList<Ship>) shipService.findShips();

		m.addAttribute("SHIPS", ships);

		return "ShowShips";
	}

	@RequestMapping(value = "/addShip", method=RequestMethod.GET)
	public String getShip(@ModelAttribute("ship") Ship ship){

		return "addShips";
	}

	@RequestMapping(value = "/addShip", method=RequestMethod.POST)
	public String postShip(@Valid @ModelAttribute("ship") Ship ship, BindingResult result){

		if(result.hasErrors()){
			return "addShips";
		}else {

			shipService.save(ship);

			return "redirect:showShips";

		}
	}
}
