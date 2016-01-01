package com.ulyssess.carrental.dao;

import java.util.Date;
import java.util.List;

import com.ulyssess.carrental.entity.Manager;

public interface ManagerDAO extends EntityDAO<Manager, Integer>{
	
	public List<Manager> findByInitials(String lastName, String firstName);
	
}
