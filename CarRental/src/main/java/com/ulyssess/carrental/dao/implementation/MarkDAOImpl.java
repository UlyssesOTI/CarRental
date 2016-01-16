package com.ulyssess.carrental.dao.implementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ulyssess.carrental.dao.MarkDAO;
import com.ulyssess.carrental.entity.Mark;

@Repository
public class MarkDAOImpl extends EntityDAOAbstract<Mark, Integer> implements MarkDAO{
	
	@PersistenceContext(unitName = "Primary")
	private EntityManager entityManager;
	
	@Transactional
	public List<Mark> findByName(List<String> names) {
		List<Mark> resList = null;
		resList = entityManager.
					createQuery("SELECT "
							+ "		m "
							+ "	FROM Mark m "
							+ "		WHERE m.markName IN :names ",Mark.class).
					setParameter("names", names).
					getResultList();
			
		return resList;
	}

	
}
