package com.ulyssess.carrental.service;

import java.util.List;
import com.ulyssess.carrental.dto.CarAllPageDTO;
import com.ulyssess.carrental.entity.Car;

public interface CarService {
	
	public void add(Car car);
	
	public void update(Car car);
		
	public List<CarAllPageDTO> findAllDTO();
}
	
	
