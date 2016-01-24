package com.ulyssess.carrental.service.implementation;


import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ulyssess.carrental.dao.ContractDAO;
import com.ulyssess.carrental.dto.ContractDTO;
import com.ulyssess.carrental.entity.Client;
import com.ulyssess.carrental.entity.Contract;
import com.ulyssess.carrental.entity.Reservation;
import com.ulyssess.carrental.service.ClientService;
import com.ulyssess.carrental.service.ContractService;
import com.ulyssess.carrental.service.ReservationService;

@Service
public class ContractServiceImpl implements ContractService{
	
	@Autowired
	private ReservationService reservationService;
	
	@Autowired
	private ClientService clientService;
	
	@Autowired
	private ContractDAO contractDAO;

	@Transactional
	public Contract createNew(String reservID, String clientId) {
		Contract contract = new Contract();
		Reservation reservation = reservationService.findById(reservID);
		Client client = clientService.findById(clientId);
		contract.setBeginDate(reservation.getBeginDate());
		contract.setEndDate(reservation.getEndDate());
		contract.setClient(client);
		contract.setPrice(reservation.getSumm());
		contract.setReservation(reservation);
		
		
		return contract;
	}

	@Transactional
	public void add(Contract contract) {
		contractDAO.add(contract);
	}

	@Transactional
	public void update(Contract contract) {
		contractDAO.update(contract);
		
	}

	@Transactional
	public List<ContractDTO> findAllDTO() {
		List<ContractDTO> contractDTOs = new ArrayList<ContractDTO>();
		List<Contract> allContract = contractDAO.findAll(Contract.class);
		for (Contract contract : allContract) {
						
			contractDTOs.add(new ContractDTO(
					contract.getId(), 
					contract.getDate().toString(),
					contract.getBeginDate().toString(), 
					contract.getEndDate().toString(),
					contract.getPrice(),
					"id: "+contract.getClient().getId()+" "
					+contract.getClient().getLastName()+" "
					+contract.getClient().getFirstName(), 
					"id: "+contract.getCar().getId()+" "+
					"regnumber: "+contract.getCar().getRegNumber()+
					" "+contract.getCar().getModel().getModelName(), "", " "));
		}
		return contractDTOs;
	}

	public Object findByClientDTO(String begin, String end, String id) {
		List<ContractDTO> contractDTOs = new ArrayList<ContractDTO>();
		List<Client> clients = new ArrayList<Client>();
		clients.add(clientService.findById(id));
		List<Contract> allContract = contractDAO.findByClients(clients);
		for (Contract contract : allContract) {
			contractDTOs.add(new ContractDTO(
					contract.getId(), 
					contract.getDate().toString(),
					contract.getBeginDate().toString(), 
					contract.getEndDate().toString(),
					contract.getPrice(),
					"id: "+contract.getClient().getId()+" "
					+contract.getClient().getLastName()+" "
					+contract.getClient().getFirstName(), 
					"id: "+contract.getCar().getId()+" "+
					"regnumber: "+contract.getCar().getRegNumber()+
					" "+contract.getCar().getModel().getModelName(), "", " "));
		}
		return contractDTOs;
	}


}
