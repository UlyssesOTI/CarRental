package com.ulyssess.carrental.dao.implementation;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ulyssess.carrental.dao.ContractDAO;
import com.ulyssess.carrental.entity.Car;
import com.ulyssess.carrental.entity.Client;
import com.ulyssess.carrental.entity.Contract;

@Repository
public class ContractDAOImpl extends EntityDAOAbstract<Contract, Integer> implements ContractDAO{
	
	@PersistenceContext(unitName = "Primary")
	private EntityManager entityManager;

	@Transactional
	public List<Contract> finfByClients(List<Client> clients) {
		List<Contract> resList = null;
		resList = entityManager.
				createQuery("SELECT"
						+ " 	c "
						+ "	FROM Contract c "
						+ "		WHERE c.client in :clients",Contract.class).
				setParameter("clients", clients).
				getResultList();
		return resList;
	}

	@Transactional
	public List<Contract> finfByCars(List<Car> cars) {
		List<Contract> resList = null;
		resList = entityManager.
				createQuery("SELECT"
						+ " 	c "
						+ "	FROM Contract c "
						+ "		WHERE c.car in :cars",Contract.class).
				setParameter("cars", cars).
				getResultList();
		return resList;
	}

	@Transactional
	public List<Contract> findByRentPeriod(Date begin, Date end) {
		List<Contract> resList = null;
		resList = entityManager.
				createQuery("SELECT"
						+ " 	c "
						+ "	FROM Contract c "
						+ "		WHERE (c.beginDate BETWEEN :begin AND :end)"
						+ " 		AND (c.endDate BETWEEN :begin AND :end)",Contract.class).
				setParameter("begin", begin).
				setParameter("end", end).
				getResultList();
		return resList;
	}

	

}
