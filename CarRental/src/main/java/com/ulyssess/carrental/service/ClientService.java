package com.ulyssess.carrental.service;

import java.util.List;

import com.ulyssess.carrental.entity.Client;

public interface ClientService {
	
	public void addClient(String lastName, String firstName, String email, String password);
	
	public List<Client> findAll();
	
}
