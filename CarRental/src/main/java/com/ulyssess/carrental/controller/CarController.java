package com.ulyssess.carrental.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ulyssess.carrental.dto.CarAllPageDTO;
import com.ulyssess.carrental.entity.Car;
import com.ulyssess.carrental.enums.Color;
import com.ulyssess.carrental.enums.GearBox;
import com.ulyssess.carrental.service.CarService;
import com.ulyssess.carrental.service.ModelService;

@Controller
public class CarController {
	
	@Autowired
	private CarService carService;
	@Autowired
	private ModelService modelService;
	
	@RequestMapping(value = "/showAllCars")
	public String getAllCars(Model model){
		model.addAttribute("cars", carService.findAll());
		return "car-all";
	}
	
	@RequestMapping(value = "/createNewCar")
	public String createCarPage(Model model) {
		model.addAttribute("color", Color.values());
		model.addAttribute("gearBox", GearBox.values());
		model.addAttribute("model", modelService.findAllModels());
		return "car-new";
	}
	 
	//@RequestParam отримує вхідне (введене) значення з веб сторінки, використовуючи ім'я input тегу.
		@RequestMapping(value = "/showAllCars", method = RequestMethod.POST)
		public String createCars(@RequestParam(value = "regNumber") String regNumber,
								 @RequestParam(value = "regDate") String regDate,
								 @RequestParam(value = "seats") String seats,
								 @RequestParam(value = "modelid") String modelid,
								 @RequestParam(value = "gearBox") String gearBox,
								 @RequestParam(value = "dayPrice") String dayPrice,
								 @RequestParam(value = "color") String color
								
								 ) {
			carService.add(regNumber, regDate, seats, gearBox, color, dayPrice, modelid);
			return "redirect:/showAllCars";
		}

}
