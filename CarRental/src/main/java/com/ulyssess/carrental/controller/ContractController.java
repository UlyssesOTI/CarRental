package com.ulyssess.carrental.controller;

import java.security.Principal;
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
import com.ulyssess.carrental.entity.Reservation;
import com.ulyssess.carrental.service.CarService;
import com.ulyssess.carrental.service.ContractService;
import com.ulyssess.carrental.service.ReservationService;

@Controller
public class ContractController {

	@Autowired
	private ContractService contractService;
	
	@Autowired
	private ReservationService reservationService;
	
	@Autowired
	private CarService carService;
	
	@RequestMapping(value="/managerAllContracts")
	private String managerAllContracts(Model model){
		model.addAttribute("contracts",contractService.findAllDTO());
		return "manager-allContracts";
	}
	
	@RequestMapping(value="/clientAllContracts")
	private String clientAllContracts(Model model, 
			Principal principal,
			@RequestParam(value="begin", defaultValue="1/1/1900") String begin,
			@RequestParam(value="end", defaultValue="1/1/9999") String end){
		model.addAttribute("contracts", contractService.findByClientDTO(begin,end,principal.getName()));
		return "client-allContracts";
	}
	
	
	@RequestMapping(value="/managerClientContracts", method= RequestMethod.POST)
	private String managerClientContracts(Model model,
			@RequestParam(value="id") String id,
			@RequestParam(value="begin", defaultValue="1/1/1900") String begin,
			@RequestParam(value="end", defaultValue="1/1/9999") String end){
		model.addAttribute("contracts", contractService.findByClientDTO(begin,end,id));
		return "manager-allContracts";
	}
	
	
	@RequestMapping(value="/managerCreateContract", method = RequestMethod.POST)
	private String managerCreateContract(Model model,
				@RequestParam(value="reservationId") String reservID,
				@RequestParam(value="clientId") String clientId,
				@RequestParam(value="modelId") String modelId){
		
		Contract contract = contractService.createNew(reservID, clientId);
		contract.setDate(new Date());
		model.addAttribute("contract", contract);	
		String begin = (contract.getBeginDate().getMonth()+1)+"/"+
				contract.getBeginDate().getDate()+"/"+
				(contract.getBeginDate().getYear()+1900);
		String end = (contract.getEndDate().getMonth()+1)+"/"+
				contract.getEndDate().getDate()+"/"+
				(contract.getEndDate().getYear()+1900);
		model.addAttribute("cars", carService.findFreeCarsDTObyModelId(begin, end, modelId));
		return "manager-newContract";
	}
	
	@RequestMapping(value="/managerSaveContract", method = RequestMethod.POST)
	private String managerSaveContract(@ModelAttribute("contract")  @Valid Contract contract, 
	 		BindingResult bindingResult,
	 		Model model){
		
		if(!bindingResult.hasErrors()){
			contractService.update(contract);
		}
		return "redirect:/managerAllContracts";
	}
}
