package com.ulyssess.carrental.formatter;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import com.ulyssess.carrental.entity.Client;
import com.ulyssess.carrental.service.ClientService;

@Component
public class ClientFormatter implements Formatter<Client>{
	
	@Autowired
	private ClientService clientService;

	public String print(Client object, Locale locale) {
		return object.getFirstName().toString();
	}

	public Client parse(String text, Locale locale) throws ParseException {
		return clientService.findById(text);
	}

}