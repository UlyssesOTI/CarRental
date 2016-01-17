package com.ulyssess.carrental.controller;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ulyssess.carrental.entity.Reservation;
import com.ulyssess.carrental.service.ClientService;
import com.ulyssess.carrental.service.ModelService;
import com.ulyssess.carrental.service.ReservationService;

@Controller
public class ReservationController {
	
	@Autowired
	private ReservationService reservationService;
	
	@Autowired
	private ModelService modelService;
	
	@Autowired
	private ClientService clientService;
	
	@RequestMapping(value="/clientReserveModel", method = RequestMethod.POST)
	private String reserveModel(Model model, Principal principal, 
				@RequestParam("id") String id){
		Reservation reservation = new Reservation();
		reservation.setModel(modelService.findById(id));
		reservation.setClient(clientService.findById(principal.getName()));
		model.addAttribute("reservation", reservation);
		return "client-reserve";
	}
	
//	@RequestMapping(value = "/clientCreateNewReservation", method = RequestMethod.POST)
//	private String clientCreateNewReservation(Model model){
//		Reservation reservation = new Reservation();
//		model.addAttribute("reservation", reservation);
//		return "reservation-new";
//	}
	
	@RequestMapping(value = "/clientSaveReservation", method = RequestMethod.POST)
	private String saveReservation(
			@ModelAttribute(value="reservation") @Valid Reservation reservation,
			//Principal principal, 
			BindingResult bindingResult,
			Model model){
		if(bindingResult.hasErrors()){
			
		}else{
			reservationService.add(reservation);
		}
		return "client-complete";
	}

}
