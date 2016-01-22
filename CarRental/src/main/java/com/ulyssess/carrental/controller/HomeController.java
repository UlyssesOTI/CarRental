package com.ulyssess.carrental.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping(value = "/")
	public String home(){
		return "client-main";
	}
	
	@RequestMapping(value = "/loginpage")
	public String loginPage(){
		return "loginpage";
	}

}
