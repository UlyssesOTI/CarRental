package com.ulyssess.carrental.dao.implementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.ulyssess.carrental.dao.EntityDAO;

@Repository
public abstract class EntityDAOAbstract<T, PK> implements EntityDAO<T, PK>{
	
	@PersistenceContext(unitName = "Primary")
	private EntityManager entityManager;

	
	@Transactional
	public void add(T obj) {
		entityManager.persist(obj);
	}

	@Transactional
	public void update(T obj) {
		entityManager.merge(obj);
	}

	@Transactional
	public void remove(T obj) {
		entityManager.remove(obj);
	}

	@Transactional
	public T findByKey(Class<T> T, PK key) {
		T obj = null;
		obj = (T) entityManager.find(T, key);
		return obj;
	}

	@Transactional
	public List<T> findAll(Class<T> T) {
		List<T> list = null;
		list = entityManager.createQuery("FROM "+T.getName(),T).getResultList();
		return list;
	}

}
