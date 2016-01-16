package com.ulyssess.carrental.dao.implementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ulyssess.carrental.dao.ClientDAO;
import com.ulyssess.carrental.entity.Client;

@Repository
public class ClientDAOImpl extends EntityDAOAbstract<Client, Integer> implements ClientDAO {
	
	@PersistenceContext(unitName = "Primary")
	private EntityManager entityManager;
	
	@Transactional
	public Client findByLogin(String login) {
		return entityManager
				.createQuery("select c from Client c where c.email like :login",
						Client.class).setParameter("login", login)
				.getSingleResult();
	}

	@Transactional
	public List<Client> findByInitials(String lastName, String firstName) {
		List<Client> resList;
		resList = entityManager.createQuery("SELECT "
				+ "		c "
				+ "FROM Client c "
				+ "		WHERE c.lastName like :lastName AND c.firstName like : firstName",
				Client.class).
				setParameter("lastName", lastName).
				setParameter("firstName", firstName).
				getResultList();
		return resList;
	}

}
