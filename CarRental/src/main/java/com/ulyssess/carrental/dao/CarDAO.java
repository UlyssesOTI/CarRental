package com.ulyssess.carrental.dao;

import java.util.Date;
import java.util.List;
import com.ulyssess.carrental.entity.Car;
import com.ulyssess.carrental.entity.Model;

public interface CarDAO extends EntityDAO<Car, Integer>{
	
	public List<Car> findRentedCars(Date begin, Date end);
	
	public Car findByRegNumber(String regNumber);
	
	public List<Car> findByModelId(int modelId);
	
	public List<Model> findByAll(int marklId, String gearbox, double maxPrice, double minPrice,Date begin, Date end);

}
