package com.ulyssess.carrental.controller;

import java.security.Principal;
import java.util.Date;
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

import com.ulyssess.carrental.dto.ReservationAllDTO;
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
				@RequestParam("id") String id,
				@RequestParam("begin") String  begin,
				@RequestParam("end") String end){
		Reservation reservation = new Reservation();
		reservation.setBeginDate(DateParse.parse(begin));
		reservation.setEndDate(DateParse.parse(end));
		reservation.setModel(modelService.findById(id));
		reservation.setClient(clientService.findById(principal.getName()));
		reservationService.caluclateSum(reservation);
		model.addAttribute("reservation", reservation);
		model.addAttribute("begin", begin);
		model.addAttribute("end", end);
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
			BindingResult bindingResult,
			Model model){
		if(bindingResult.hasErrors()){
			
		}else{
			reservation.setDate(new Date());
			reservationService.add(reservation);
		}
		return "client-complete";
	}
	
	@RequestMapping(value="/managerNewReservations")
	private String managerNewReservations(Model model,
					@RequestParam(value="begin", defaultValue="1/1/1900") String begin,
					@RequestParam(value="end", defaultValue="1/1/9999") String end){
		List<ReservationAllDTO> list = reservationService.findNewReservations(begin, end);
		model.addAttribute("reservations", list);
		return "manager-allNewReservations";
	}

}
