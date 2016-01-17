package com.ulyssess.carrental.controller;

import java.util.Date;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ulyssess.carrental.dao.validator.FileClass;
import com.ulyssess.carrental.dao.validator.FileValidator;
import com.ulyssess.carrental.entity.Car;
import com.ulyssess.carrental.enums.Color;
import com.ulyssess.carrental.service.CarService;
import com.ulyssess.carrental.service.ModelService;

@Controller
public class CarController {
	
	@Autowired
	private CarService carService;
	
	@Autowired
	private ModelService modelService;
	
	@Autowired
	FileValidator fileValidator;
	
	@Autowired
	CarValidator carValidator;
	
	@InitBinder("car")
	private void initBinderCar(WebDataBinder binder) {
		binder.setValidator(carValidator);
	}
	
	@InitBinder("file")
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(fileValidator);
	}

	@RequestMapping(value = "/file", method = RequestMethod.GET)
	public String getForm(Model model) {
		FileClass fileModel = new FileClass();
		model.addAttribute("file", fileModel);
		return "file";
	}
	
	@RequestMapping(value = "/managerShowAllCars")
	public String getAllCars(Model model){
		model.addAttribute("cars", carService.findAllDTO());
		return "car-all";
	}
	
	@RequestMapping(value = "/managerCreateNewCar")
	public String createCarPage(Model model) {
		Car car = new Car();
		model.addAttribute("car", car);
		model.addAttribute("colors", Color.values());
		model.addAttribute("models", modelService.findAll());
		return "car-new";
	}
	 
	@RequestMapping(value = "/managerNewCar", method = RequestMethod.POST)
	public String createCars(
			 		@ModelAttribute("car")  @Valid Car car, 
			 		BindingResult result,
			 		Model model){
		
		String returnVal = "redirect:/managerShowAllCars";
		if (result.hasErrors()) {
			returnVal = "redirect:/managerCreateNewCar";
		} else {			
			car.setRegDate(new Date());
			carService.add(car);
		}
		return returnVal;
	}
		
}
