package com.ulyssess.carrental.controller;

import java.security.Principal;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ulyssess.carrental.dto.ModelAllPageDTO;
import com.ulyssess.carrental.entity.Client;
import com.ulyssess.carrental.service.ClientService;
import com.ulyssess.carrental.service.ModelService;

@Controller
public class ClientController {

	@Autowired
	private ModelService modelService;
	
	@Autowired
	private ClientService clientService;
	
	@RequestMapping(value = "/allClientsMain")
	public String clientMain(){
		return "client-main";
	}
	
	@RequestMapping(value="/allClientsAvailableModels", method=RequestMethod.POST)
	private String availableModels(
				Model model, 
				@RequestParam("begin") String begin, 
				@RequestParam("end") String end){
		List<ModelAllPageDTO> models = modelService.findAvailableModelsByPeriod(begin, end);
		model.addAttribute("models", models);
		return "client-main";
	}
	
	@RequestMapping(value="/signIn")
	public String signIn(Model model){
		Client client = new Client();
		model.addAttribute("client", client);
		return "client-new";
	}
	
	@RequestMapping(value = "/allClientsNewClient", method=RequestMethod.POST)
	public String newClient(@ModelAttribute("client")  @Valid Client client,
			@RequestParam(value="operation") String operation,
	 		BindingResult bindingResult,
	 		Model model){
		
		String returnVal = "redirect:/loginpage";
		if(bindingResult.hasErrors()){
			returnVal = "";
		}else{
			if(operation.equals("add")){
				clientService.add(client);
			}else if(operation.equals("update")){
				
			}else if(operation.equals("remove")){
				
			}
		}
		return returnVal;
	}
	
	
}
