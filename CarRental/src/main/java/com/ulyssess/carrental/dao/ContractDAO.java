package com.ulyssess.carrental.dao;

import java.util.Date;
import java.util.List;

import com.ulyssess.carrental.entity.Car;
import com.ulyssess.carrental.entity.Client;
import com.ulyssess.carrental.entity.Contract;
import com.ulyssess.carrental.entity.Manager;

public interface ContractDAO extends EntityDAO<Contract, Integer>{
	
	public List<Contract> finfByClients(List<Client> clients);
	
	public List<Contract> finfByCars(List<Car> cars);
	
	public List<Contract> findByRentPeriod(Date begin, Date end);

}
