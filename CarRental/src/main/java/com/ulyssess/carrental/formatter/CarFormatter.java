package com.ulyssess.carrental.formatter;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import com.ulyssess.carrental.entity.Car;
import com.ulyssess.carrental.service.CarService;

@Component
public class CarFormatter implements Formatter<Car>{
	
	@Autowired
	private CarService carService;

	public String print(Car object, Locale locale) {
		return object.toString();
	}

	public Car parse(String Id, Locale locale) throws ParseException {
		return carService.findById(Id);
	}

}