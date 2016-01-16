package com.ulyssess.carrental.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ManagerController {
	
	@RequestMapping(value = "/managerMain")
	public String managerMain(){
		return "manager-main";
	}
	
}
