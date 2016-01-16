package com.ulyssess.carrental.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ulyssess.carrental.dao.ClientDAO;
import com.ulyssess.carrental.entity.Client;
import com.ulyssess.carrental.service.ClientService;

@Service
public class ClientServiceImpl implements ClientService{
	
	@Autowired
	private ClientDAO clientDAO;

	@Transactional
	public void add(Client client) {
		clientDAO.add(client);
	}

	@Transactional
	public List<Client> findAll() {
		return clientDAO.findAll(Client.class);
	}

}
