package com.ulyssess.carrental.service.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ulyssess.carrental.controller.DateParse;
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

	public List<Reservation> findNewReservations(String begin, String end) {
		List<Reservation> resList = new ArrayList<Reservation>();
		resList = reservationDAO.findNewReservations(DateParse.parse(begin), DateParse.parse(end));
		return resList;
	}

}
