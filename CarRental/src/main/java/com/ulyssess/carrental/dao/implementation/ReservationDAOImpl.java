package com.ulyssess.carrental.dao.implementation;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ulyssess.carrental.dao.ReservationDAO;
import com.ulyssess.carrental.entity.Reservation;

@Repository
public class ReservationDAOImpl extends EntityDAOAbstract<Reservation, Integer> implements ReservationDAO{
	
	@PersistenceContext(unitName = "Primary")
	private EntityManager entityManager;

	@Transactional
	public List<Reservation> findNewReservations(Date begin, Date end) {
		List<Reservation> resList = null;
		
		resList = entityManager.
		createQuery("SELECT "
				+ "		r "
				+ "	FROM Reservation r "
					+ "		WHERE (r.date BETWEEN :begin AND :end) "+
					"			AND (r not in (SELECT c.reservation FROM Contract c)) ",
					Reservation.class).
		setParameter("begin", begin).
		setParameter("end", end).
		getResultList();

		return resList;
	}

}
