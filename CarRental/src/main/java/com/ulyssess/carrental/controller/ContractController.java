package com.ulyssess.carrental.controller;

import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ulyssess.carrental.entity.Contract;
import com.ulyssess.carrental.service.CarService;
import com.ulyssess.carrental.service.ContractService;

@Controller
public class ContractController {

	@Autowired
	private ContractService contractService;
	
	@Autowired
	private CarService carService;
	
	@RequestMapping(value="managerCreateContract", method = RequestMethod.POST)
	private String managerCreateContract(Model model,
				@RequestParam(value="reservationId") String reservID,
				@RequestParam(value="clientId") String clientId,
				@RequestParam(value="modelId") String modelId){
		
		Contract contract = contractService.createNewContract(reservID, clientId);
		contract.setDate(new Date());
		model.addAttribute("contract", contract);	
		String begin = contract.getBeginDate().getMonth()+"/"+
				contract.getBeginDate().getDate()+"/"+
				contract.getBeginDate().getYear();
		String end = contract.getEndDate().getMonth()+"/"+
				contract.getEndDate().getDate()+"/"+
				contract.getEndDate().getYear();
		model.addAttribute("cars", carService.findFreeCarsDTObyModelId(begin, end, modelId));
		return "manager-newContract";
	}
	
	@RequestMapping(value="managerSaveContract", method = RequestMethod.POST)
	private String managerSaveContract(@ModelAttribute("contract")  @Valid Contract contract, 
	 		BindingResult bindingResult,
	 		Model model){
		
		if(!bindingResult.hasErrors()){
			contractService.update(contract);
		}
		return "manager-allContracts";
	}
}
