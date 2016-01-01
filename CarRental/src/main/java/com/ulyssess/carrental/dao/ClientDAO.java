package com.ulyssess.carrental.dao;

import java.util.Date;
import java.util.List;

import com.ulyssess.carrental.entity.Client;

public interface ClientDAO extends EntityDAO<Client, Integer> {
			
	public List<Client> findByInitials(String lastName, String firstName);
	
}
