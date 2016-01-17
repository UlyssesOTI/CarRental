package com.ulyssess.carrental.dao.implementation;

import org.springframework.stereotype.Repository;

import com.ulyssess.carrental.dao.ReservationDAO;
import com.ulyssess.carrental.entity.Reservation;

@Repository
public class ReservationDAOImpl extends EntityDAOAbstract<Reservation, Integer> implements ReservationDAO{

}
