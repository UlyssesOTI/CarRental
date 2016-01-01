package com.ulyssess.carrental.dao.implementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.ulyssess.carrental.dao.ModelDAO;
import com.ulyssess.carrental.entity.Mark;
import com.ulyssess.carrental.entity.Model;
import com.ulyssess.carrental.enums.ModelClass;

@Repository
public class ModelDAOImpl extends EntityDAOAbstract<Model, Integer> implements ModelDAO{

	@PersistenceContext(unitName = "Primary")
	private EntityManager entityManager;
	
	public List<Model> findByModelClass(ModelClass modelClass) {
		List<Model> resList = null;
		resList = entityManager.
					createQuery("SELECT "
							+ "		m "
							+ "	FROM Model m "
							+ "		WHERE m.modelClass = :modelClass ",Model.class).
					setParameter("modelClass", modelClass).
					getResultList();
			
		return resList;
	}

	@Transactional
	public List<Model> findByMark(Mark mark) {
		List<Model> resList = null;
		resList = entityManager.
					createQuery("SELECT "
							+ "		m "
							+ "	FROM Model m "
							+ "		WHERE m.mark = :mark ",Model.class).
					setParameter("mark", mark).
					getResultList();
			
		return resList;
	}

	
}
