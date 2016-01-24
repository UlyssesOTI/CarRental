package com.ulyssess.carrental.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ulyssess.carrental.enums.GearBox;
import com.ulyssess.carrental.service.MarkService;

@Controller
public class HomeController {
	
	@Autowired
	private MarkService markService;
	
	@RequestMapping(value = "/")
	public String home(Model model){
//		model.addAttribute("marks", markService.findAll());
//		model.addAttribute("gearBoxs",GearBox.values());
		return "redirect:/AvailableModels";
	}
	
	@RequestMapping(value = "/loginpage")
	public String loginPage(){
		return "loginpage";
	}

}
