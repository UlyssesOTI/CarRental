package com.ulyssess.carrental.service;

import java.util.List;
import com.ulyssess.carrental.dto.CarAllPageDTO;
import com.ulyssess.carrental.entity.Car;
import com.ulyssess.carrental.entity.Model;

public interface CarService {
	
	public void add(Car car);
	
	public void update(Car car);
	
	public Car findById(String Id);
		
	public List<CarAllPageDTO> findAllDTO();
	
	public List<CarAllPageDTO> findFreeCarsDTObyModelId(String begin, String end, String modelId);
}
	
	
