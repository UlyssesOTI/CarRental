package com.ulyssess.carrental.service;

import java.util.List;

import com.ulyssess.carrental.dto.ContractDTO;
import com.ulyssess.carrental.entity.Contract;

public interface ContractService {
	
	public Contract createNew(String reservID,String clientId);

	public void add(Contract contract);
	
	public void update(Contract contract);
	
	public List<ContractDTO> findAllDTO();

	public Object findByClientDTO(String begin, String end, String id);
}
