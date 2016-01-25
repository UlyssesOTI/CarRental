package com.ulyssess.carrental.controller;

import java.security.Principal;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

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
import com.ulyssess.carrental.enums.GearBox;
import com.ulyssess.carrental.service.ClientService;
import com.ulyssess.carrental.service.MarkService;
import com.ulyssess.carrental.service.ModelService;

@Controller
public class ClientController {

	@Autowired
	private ModelService modelService;

	@Autowired
	private MarkService markService;
	
	@Autowired
	private ClientService clientService;
	
	@RequestMapping(value = "/allClientsMain")
	public String clientMain(){
		return "client-main";
	}
	
	@RequestMapping(value="/AvailableModels", method = {RequestMethod.GET, RequestMethod.POST})
	private String availableModels(
				Model model, 
				@RequestParam(value = "begin" , defaultValue="01/01/0001")  String begin, 
				@RequestParam(value = "end", defaultValue="01/01/0001") String end,
				@RequestParam(value = "mark", defaultValue="0") String markId,
				@RequestParam(value = "gearBox", defaultValue="-1") String gearBoxId,
				@RequestParam(value = "minPrice", defaultValue="0") String minPrice,
				@RequestParam(value = "maxPrice", defaultValue="0") String maxPrice){
		
		List<ModelAllPageDTO> models = modelService.findAvailableModelsByPeriod(begin, end, markId, gearBoxId,minPrice, maxPrice);
		model.addAttribute("models", models);
		model.addAttribute("begin", begin);
		model.addAttribute("end", end);
		model.addAttribute("marks", markService.findAll());
		model.addAttribute("markId", markId);
		model.addAttribute("gearBoxs",GearBox.values());
		model.addAttribute("gearBoxId",gearBoxId);
		model.addAttribute("minPrice",minPrice);
		model.addAttribute("maxPrice",maxPrice);
		model.addAttribute("days",DateParse.getDateDiff(DateParse.parse(begin), DateParse.parse(end), TimeUnit.DAYS));
		return "client-main";
	}
	
	@RequestMapping(value="/signIn")
	public String signIn(Model model){
		Client client = new Client();
		model.addAttribute("client", client);
		return "client-new";
	}
	
	@RequestMapping(value = "/newClient", method=RequestMethod.POST)
	public String newClient(@ModelAttribute("client")  @Valid Client client,
			@RequestParam(value="operation") String operation,
	 		BindingResult bindingResult,
	 		Model model){
			
		String returnVal = "redirect:/loginpage";
		if(bindingResult.hasErrors()){
			returnVal = "";
		}else{
			if(operation.equals("add")){
				client.setRegDate(new Date());
				clientService.add(client);
			}else if(operation.equals("update")){
				
			}else if(operation.equals("remove")){
				
			}
		}
		return returnVal;
	}
	
	@RequestMapping(value="/mClients")
	public String managerAllClients(Model model){
		model.addAttribute("clients", clientService.findAll());
		return "manager-allClients";
	}
	
	@RequestMapping(value="/cPersonalInfo")
	public String clientPersonalInfo(Model model, Principal principal){
		model.addAttribute("client", clientService.findById(principal.getName()));
		return "client-edit";
	}
	
	
}
