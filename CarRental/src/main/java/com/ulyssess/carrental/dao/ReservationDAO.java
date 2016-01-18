package com.ulyssess.carrental.dao;

import java.util.Date;
import java.util.List;

import com.ulyssess.carrental.entity.Reservation;

public interface ReservationDAO extends EntityDAO<Reservation, Integer>{
	
	public List<Reservation> findNewReservations(Date begin, Date end);

}
