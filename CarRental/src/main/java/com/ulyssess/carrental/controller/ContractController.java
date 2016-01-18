package com.ulyssess.carrental.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ulyssess.carrental.entity.Car;
import com.ulyssess.carrental.entity.Contract;
import com.ulyssess.carrental.service.ContractService;

@Controller
public class ContractController {

	@Autowired
	private ContractService contractService;
	
	@RequestMapping(value="managerCreateContract", method = RequestMethod.POST)
	private String managerCreateContract(Model model,
				@RequestParam(value="reservationId") String reservID,
				@RequestParam(value="clientId") String clientId,
				@RequestParam(value="modelId") String modelId){
		
		Contract contract = contractService.createNewContract(reservID, clientId);
		model.addAttribute("contract", contract);	
		return "manager-newContract";
	}
	
	@RequestMapping(value="managerSaveContract", method = RequestMethod.POST)
	private String managerSaveContract(@ModelAttribute("contract")  @Valid Contract contract, 
	 		BindingResult result,
	 		Model model){
		
		//Contract contract = contractService.createNewContract(reservID, clientId);
		//model.addAttribute("contract", contract);	
		return "manager-newContract";
	}
}
