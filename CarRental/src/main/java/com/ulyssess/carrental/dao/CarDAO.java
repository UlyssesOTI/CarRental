package com.ulyssess.carrental.dao;

import java.util.Date;
import java.util.List;
import com.ulyssess.carrental.entity.Car;

public interface CarDAO extends EntityDAO<Car, Integer>{
	
	public List<Car> findRentedCars(Date begin, Date end);
	
	public Car findByRegNumber(String regNumber);
	
	public List<Car> findByModelId(int modelId);
	
	public List<Car> findByAll(int marklId, double maxPrice, double minPrice);

}
