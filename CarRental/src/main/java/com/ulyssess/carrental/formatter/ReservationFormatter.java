package com.ulyssess.carrental.formatter;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import com.ulyssess.carrental.entity.Reservation;
import com.ulyssess.carrental.service.ReservationService;

@Component
public class ReservationFormatter implements Formatter<Reservation>{

	@Autowired
	private ReservationService reservationService;
	
	public String print(Reservation object, Locale locale) {
		return object.toString();
	}

	public Reservation parse(String id, Locale locale) throws ParseException {
		return reservationService.findById(id);
	}

}
