package com.ulyssess.carrental.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ulyssess.carrental.dao.ClientDAO;
import com.ulyssess.carrental.entity.Client;
import com.ulyssess.carrental.service.ClientService;

@Service
public class ClientServiceImpl implements ClientService{
	
	@Autowired
	private ClientDAO clientDAO;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Transactional
	public void add(Client client) {
		client.setPassword(encoder.encode(client.getPassword()));
		clientDAO.add(client);
	}

	@Transactional
	public List<Client> findAll() {
		return clientDAO.findAll(Client.class);
	}

	@Transactional
	public Client findById(String id) {
		int clientId=0;
		Client client = null;
		try {
			clientId = Integer.parseInt(id);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		if(clientId != 0){
			client = clientDAO.findByKey(Client.class, clientId);
		}
		return client;
	}

}
