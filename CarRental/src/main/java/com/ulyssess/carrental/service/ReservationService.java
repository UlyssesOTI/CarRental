package com.ulyssess.carrental.service;

import java.util.List;

import com.ulyssess.carrental.entity.Reservation;

public interface ReservationService {
	
	public void add(Reservation reservation);
	
	public void update(Reservation reservation);
	
	public List<Reservation> findNewReservations(String begin, String end);

}
