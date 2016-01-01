package com.ulyssess.carrental.dao;

import java.util.Date;
import java.util.List;

import com.ulyssess.carrental.entity.Car;
import com.ulyssess.carrental.entity.Model;
import com.ulyssess.carrental.enums.Color;

public interface CarDAO extends EntityDAO<Car, Integer>{
	
	public List<Car> findRentedCars(Date begin, Date end);
	
	public Car findByRegNumber(String regNumber);

}
