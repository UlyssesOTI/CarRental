package com.ulyssess.carrental.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.ulyssess.carrental.dto.CarAllPageDTO;
import com.ulyssess.carrental.entity.Car;
import com.ulyssess.carrental.enums.Color;
import com.ulyssess.carrental.enums.GearBox;
import com.ulyssess.carrental.file.FileClass;
import com.ulyssess.carrental.file.FileValidator;
import com.ulyssess.carrental.service.CarService;
import com.ulyssess.carrental.service.ModelService;

@Controller
public class CarController {
	
	@Autowired
	private CarService carService;
	@Autowired
	private ModelService modelService;
	
	@Autowired
	FileValidator validator;
	
	@Autowired
	private ConversionService conversionService;
	//Autowiring the ConversionService we declared in the context file above.
	 
	@InitBinder
	public void registerConversionServices(WebDataBinder dataBinder) {
		if(dataBinder.getConversionService() == null)
			dataBinder.setConversionService(conversionService);
    
		
		}

//	@InitBinder
//	private void initBinder(WebDataBinder binder) {
//		binder.setValidator(validator);
//	}

	@RequestMapping(value = "/file", method = RequestMethod.GET)
	public String getForm(Model model) {
		FileClass fileModel = new FileClass();
		model.addAttribute("file", fileModel);
		return "file";
	}
	
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
	public String createCars(
			@ModelAttribute("movie") @Valid Car car, 
			BindingResult result,
			Model model								
							 ) throws IOException {
		
		String returnVal = "redirect:/showAllCars";
		if (result.hasErrors()) {
			System.out.println(car.getModel().getId());
			//returnVal = "file";
		} else {			
			//MultipartFile multipartFile = file.getFile();
			//byte[] bFile = multipartFile.getBytes();
			//carService.add(regNumber, regDate, seats, gearBox, color, dayPrice, modelid, bFile);		    
		}
		return returnVal;
	}
	
	
	
//		@RequestMapping(value = "/showAllCars", method = RequestMethod.POST)
//		public String createCars(Model model,
//				@Validated FileClass file,
//				BindingResult result, @RequestParam(value = "regNumber")	String regNumber,
//								 @RequestParam(value = "regDate") String regDate,
//								 @RequestParam(value = "seats") String seats,
//								 @RequestParam(value = "modelid") String modelid,
//								 @RequestParam(value = "gearBox") String gearBox,
//								 @RequestParam(value = "dayPrice") String dayPrice,
//								 @RequestParam(value = "color") String color
//																
//								 ) throws IOException {
//			
//			String returnVal = "redirect:/showAllCars";
//			if (result.hasErrors()) {
//				returnVal = "file";
//			} else {			
//				MultipartFile multipartFile = file.getFile();
//				byte[] bFile = multipartFile.getBytes();
//				carService.add(regNumber, regDate, seats, gearBox, color, dayPrice, modelid, bFile);		    
//			}
//			return returnVal;
//		}

}
