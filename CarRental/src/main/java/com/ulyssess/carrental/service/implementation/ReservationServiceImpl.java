package com.ulyssess.carrental.service.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ulyssess.carrental.controller.DateParse;
import com.ulyssess.carrental.dao.ReservationDAO;
import com.ulyssess.carrental.dto.ReservationAllDTO;
import com.ulyssess.carrental.entity.Reservation;
import com.ulyssess.carrental.service.ReservationService;

@Service
public class ReservationServiceImpl implements ReservationService {

	@Autowired
	private ReservationDAO reservationDAO;
	
	@Transactional
	public void add(Reservation reservation) {
		reservationDAO.add(reservation);
	}

	@Transactional
	public void update(Reservation reservation) {
		reservationDAO.update(reservation);	
	}

	@Transactional
	public List<ReservationAllDTO> findNewReservations(String begin, String end) {
		List<ReservationAllDTO> resList = new ArrayList<ReservationAllDTO>();
		List<Reservation> list = new ArrayList<Reservation>();
		list = reservationDAO.findNewReservations(DateParse.parse(begin), DateParse.parse(end));
		for (Reservation reservation : list) {
			resList.add(new ReservationAllDTO(	
					reservation.getId(), 
					reservation.getDate().toString(), 
					reservation.getBeginDate().toString(), 
					reservation.getEndDate().toString(), 
					reservation.getSumm().toString(), 
					reservation.getClient().getId(), 
					reservation.getClient().getLastName(), 
					reservation.getClient().getFirstName(), 
					reservation.getModel().getId(), 
					reservation.getModel().getModelName(), 
					(reservation.getContract()==null)? 0 : reservation.getContract().getId()));
		}
		return resList;
		
		
	}

	@Transactional
	public Reservation findById(String id) {
		int reservationId=0;
		Reservation reservation = null;
		try {
			reservationId = Integer.parseInt(id);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		if(reservationId != 0){
			reservation = reservationDAO.findByKey(Reservation.class, reservationId);
		}
		return reservation;
	}

}
