package com.ulyssess.carrental.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ulyssess.carrental.dao.ReservationDAO;
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

}
