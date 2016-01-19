package com.ulyssess.carrental.service;

import com.ulyssess.carrental.entity.Contract;

public interface ContractService {
	
	public Contract createNewContract(String reservID,String clientId);

	public void add(Contract contract);
	
	public void update(Contract contract);
}
