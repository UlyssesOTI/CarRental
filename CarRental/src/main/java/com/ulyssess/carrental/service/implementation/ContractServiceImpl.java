package com.ulyssess.carrental.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ulyssess.carrental.entity.Client;
import com.ulyssess.carrental.entity.Contract;
import com.ulyssess.carrental.entity.Model;
import com.ulyssess.carrental.entity.Reservation;
import com.ulyssess.carrental.service.ClientService;
import com.ulyssess.carrental.service.ContractService;
import com.ulyssess.carrental.service.ModelService;
import com.ulyssess.carrental.service.ReservationService;

@Service
public class ContractServiceImpl implements ContractService{
	
	@Autowired
	private ReservationService reservationService;
	
	@Autowired
	private ClientService clientService;
	
	@Autowired
	private ModelService modelService;

	@Transactional
	public Contract createNewContract(String reservID, String clientId) {
		Contract contract = new Contract();
		Reservation reservation = reservationService.findById(reservID);
		Client client = clientService.findById(clientId);
		//Model model = modelService.findById(modelId);
		
		contract.setBeginDate(reservation.getBeginDate());
		contract.setEndDate(reservation.getEndDate());
		contract.setClient(client);
		contract.setPrice(reservation.getSumm());
		contract.setReservation(reservation);
		
		
		return contract;
	}


}
