package com.ulyssess.carrental.dao;

import java.util.List;

public interface EntityDAO<T,PK> {
	
	public void add(T obj);
	
	public void update(T obj);
	
	public void remove(T obj);
	
	public T findByKey(Class<T> T,PK key);
	
	public List<T> findAll(Class<T> T);
	
}
