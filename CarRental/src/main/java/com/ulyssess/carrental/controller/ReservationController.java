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
	
	@RequestMapping(value="/cReserveModel", method = RequestMethod.POST)
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
		
	@RequestMapping(value = "/cSaveReservation", method = RequestMethod.POST)
	private String saveReservation(
			@ModelAttribute(value="reservation") @Valid Reservation reservation,
			BindingResult bindingResult,
			Model model){
		if(bindingResult.hasErrors()){
			
		}else{
			reservation.setDate(new Date());
			reservationService.add(reservation);
		}
		return "redirect:/cCurrentReservations";
	}
	
	@RequestMapping(value="cCurrentReservations")
	private String clientCurrentReservations(Model model, 
			Principal principal,
			@RequestParam(value="begin", defaultValue="1/1/1900") String begin,
			@RequestParam(value="end", defaultValue="1/1/9999") String end){
		model.addAttribute("reservations", reservationService.findClientReservations(begin, end, principal.getName(),true));
		return "client-allReservations";
	}
	
	@RequestMapping(value="cAllReservations")
	private String clientAllReservations(Model model, 
			Principal principal,
			@RequestParam(value="begin", defaultValue="1/1/1900") String begin,
			@RequestParam(value="end", defaultValue="1/1/9999") String end){
		model.addAttribute("reservations", reservationService.findClientReservations(begin, end, principal.getName(),false));
		return "client-allReservations";
	}
	
	@RequestMapping(value="cDiscardReservation")
	private String clientDiscardReservation(@RequestParam(value="id") String id){
		reservationService.remove(id);
		return "redirect:/cCurrentReservations";
	}
	
	@RequestMapping(value="/mNewReservations")
	private String managerNewReservations(Model model,
					@RequestParam(value="begin", defaultValue="1/1/1900") String begin,
					@RequestParam(value="end", defaultValue="1/1/9999") String end){
		List<ReservationAllDTO> list = reservationService.findReservations(begin, end,true);
		model.addAttribute("reservations", list);
		return "manager-allReservations";
	}
	
	@RequestMapping(value="/mAllReservations")
	private String managerAllReservations(Model model,
					@RequestParam(value="begin", defaultValue="1/1/1900") String begin,
					@RequestParam(value="end", defaultValue="1/1/9999") String end){
		List<ReservationAllDTO> list = reservationService.findReservations(begin, end,false);
		model.addAttribute("reservations", list);
		return "manager-allReservations";
	}

}
