package com.ulyssess.carrental.service.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

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
	public List<ReservationAllDTO> findReservations(String begin, String end, boolean onlyNew) {
		List<ReservationAllDTO> resList = new ArrayList<ReservationAllDTO>();
		List<Reservation> list = new ArrayList<Reservation>();
		list = reservationDAO.findReservations(DateParse.parse(begin), DateParse.parse(end),onlyNew);
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

	@Transactional
	public void caluclateSum(Reservation reservation) {
		reservation.setSumm(
				reservation.getModel().getDayPrice()*
				DateParse.getDateDiff(reservation.getBeginDate(),reservation.getEndDate(), TimeUnit.DAYS));
		
	}

	@Transactional
	public List<ReservationAllDTO> findClientReservations(String begin, String end, String id, boolean onlyNew ) {
		List<ReservationAllDTO> resList = new ArrayList<ReservationAllDTO>();
		List<Reservation> list = new ArrayList<Reservation>();
		
		list = reservationDAO.findClientReservations(DateParse.parse(begin), DateParse.parse(end),Integer.parseInt(id),onlyNew);
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
	public void remove(String id) {
		Reservation reservation = reservationDAO.findByKey(Reservation.class, Integer.parseInt(id));
		reservationDAO.remove(reservation);
		
	}

}
