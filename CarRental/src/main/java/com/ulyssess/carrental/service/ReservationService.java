package com.ulyssess.carrental.service;

import java.util.List;

import com.ulyssess.carrental.dto.ReservationAllDTO;
import com.ulyssess.carrental.entity.Reservation;

public interface ReservationService {
	
	public void add(Reservation reservation);
	
	public void update(Reservation reservation);
	
	public void remove(String id);
	
	public Reservation findById(String id);
	
	public List<ReservationAllDTO> findReservations(String begin, String end, boolean onlyNew);
	
	public void caluclateSum(Reservation reservation);

	public List<ReservationAllDTO> findClientReservations(String begin, String end, String id,  boolean onlyNew);

}
