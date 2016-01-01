package com.ulyssess.carrental.dao.implementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import com.ulyssess.carrental.dao.ManagerDAO;
import com.ulyssess.carrental.entity.Manager;

public class ManagerDAOImpl extends EntityDAOAbstract<Manager, Integer> implements ManagerDAO{
	
	@PersistenceContext(unitName = "Primary")
	private EntityManager entityManager;

	@Transactional
	public List<Manager> findByInitials(String lastName, String firstName) {
		List<Manager> resList = null;
		resList = entityManager.createQuery("SELECT "
				+ "		m "
				+ "FROM Manager m "
				+ "		WHERE m.lastName like :lastName AND m.firstName like : firstName",
				Manager.class).
				setParameter("lastName", lastName).
				setParameter("firstName", firstName).
				getResultList();
		return resList;
	}

}
