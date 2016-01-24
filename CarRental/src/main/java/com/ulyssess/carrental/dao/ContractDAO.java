package com.ulyssess.carrental.dao;

import java.util.Date;
import java.util.List;

import com.ulyssess.carrental.entity.Car;
import com.ulyssess.carrental.entity.Client;
import com.ulyssess.carrental.entity.Contract;

public interface ContractDAO extends EntityDAO<Contract, Integer>{
	
	public List<Contract> findByClients(List<Client> clients);
	
	public List<Contract> findByCars(List<Car> cars);
	
	public List<Contract> findByRentPeriod(Date begin, Date end);

}
