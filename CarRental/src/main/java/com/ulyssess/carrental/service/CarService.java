package com.ulyssess.carrental.service;

import java.util.List;

import com.ulyssess.carrental.dto.CarAllPageDTO;
import com.ulyssess.carrental.entity.Car;
import com.ulyssess.carrental.entity.Model;


public interface CarService {
	
	//public void add(String regNumber,String regDate,  String seats, String gearBox, String color, String dayPrice, String modelId, byte[] image);
	public void add(Car car);
	
	public void update(Car car);
		
	public List<CarAllPageDTO> findAll();
}
	
	
