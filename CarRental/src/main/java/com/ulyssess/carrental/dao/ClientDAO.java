package com.ulyssess.carrental.dao;

import java.util.List;

import com.ulyssess.carrental.entity.Client;

public interface ClientDAO extends EntityDAO<Client, Integer> {
	
	public Client findByLogin(String login);
			
	public List<Client> findByInitials(String lastName, String firstName);
	
}
