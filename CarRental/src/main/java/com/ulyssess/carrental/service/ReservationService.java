package com.ulyssess.carrental.service;

import java.util.List;

import com.ulyssess.carrental.dto.ReservationAllDTO;
import com.ulyssess.carrental.entity.Reservation;

public interface ReservationService {
	
	public void add(Reservation reservation);
	
	public void update(Reservation reservation);
	
	public Reservation findById(String id);
	
	public List<ReservationAllDTO> findNewReservations(String begin, String end);
	
	public void caluclateSum(Reservation reservation);

}
