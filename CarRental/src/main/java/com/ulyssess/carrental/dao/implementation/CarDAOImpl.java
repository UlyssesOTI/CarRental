package com.ulyssess.carrental.dao.implementation;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ulyssess.carrental.dao.CarDAO;
import com.ulyssess.carrental.entity.Car;

@Repository
public class CarDAOImpl extends EntityDAOAbstract<Car, Integer> implements CarDAO{
	
	@PersistenceContext(unitName = "Primary")
	private EntityManager entityManager;
	
	
	@Transactional
	public List<Car> findRentedCars(Date begin, Date end) {
		List<Car> resList = null;
			
		resList = entityManager.
				createQuery("SELECT "
						+ "		c.car "
						+ "	FROM Contract c "
							+ "		WHERE (c.beginDate BETWEEN :start AND :end) "
							+ "			OR (c.endDate BETWEEN :start AND :end) ",
							Car.class).
				setParameter("start", begin).
				setParameter("end", end).
				getResultList();
				
		return resList;
	}

	@Transactional
	public Car findByRegNumber(String regNumber) {
		Car resCar = null;
		
		resCar = entityManager.
				createQuery("SELECT "
						+ "		c.car "
						+ "	FROM Contract c "
							+ "		WHERE c.regNumber like :regNumber",
							Car.class).
				setParameter("regNumber", regNumber).
				setMaxResults(1).getSingleResult();
				
		return resCar;
	}

	@Transactional
	public List<Car> findByModelId(int modelId) {
		List<Car> resList = null;
		
		resList = entityManager.
				createQuery("SELECT "
						+ "		c "
						+ "	FROM Car c "
							+ "		WHERE (c.model.id = :modelId)",
							Car.class).
				setParameter("modelId", modelId).
				getResultList();
				
		return resList;
	}

}
