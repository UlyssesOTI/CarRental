package com.ulyssess.carrental.dao.implementation;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ulyssess.carrental.dao.CarDAO;
import com.ulyssess.carrental.entity.Car;

@Repository
public class CarDAOImpl extends EntityDAOAbstract<Car, Integer> implements CarDAO{
	
	@PersistenceContext(unitName = "Primary")
	private EntityManager entityManager;
	
	
	

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
	
	@Transactional
	public List<Car> findByAll(int marklId, int gearboxId, double maxPrice, double minPrice,Date begin, Date end) {
		List<Car> resList = null;
		
		String query = "SELECT "
				+ "		c "
				+ "	FROM Car c "
				+ "WHERE c.model.dayPrice >= :minPrice AND c.model.dayPrice <= :maxPrice"+
				" AND c not in (SELECT "
						+ "		c.car "
						+ "	FROM Contract c "
							+ "		WHERE (c.beginDate BETWEEN :start AND :end) "
							+ "			OR (c.endDate BETWEEN :start AND :end) )";
				
		
				if(marklId!=0){
					query = query+ "	AND	c.model.mark.id = :marklId";
				}
				
				if(gearboxId>=0){
					query = query+ "	AND	c.model.gearBox.id = :gearboxId";
				}
			
				TypedQuery<Car> Tquery = entityManager.createQuery(query,Car.class);
				
				Tquery.setParameter("maxPrice", maxPrice).
				setParameter("minPrice", minPrice).
				setParameter("start", begin).
				setParameter("end", end);
				
				if(marklId!=0){
					Tquery.setParameter("marklId", marklId);					
				}
				if(gearboxId>=0){
					Tquery.setParameter("gearboxId", gearboxId);
				}
		
				resList = Tquery.getResultList();
			
		return resList;
	}
	
	
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

}
