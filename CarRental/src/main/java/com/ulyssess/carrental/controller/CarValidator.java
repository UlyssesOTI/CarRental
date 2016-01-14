package com.ulyssess.carrental.controller;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.ulyssess.carrental.entity.Car;

@Component
public class CarValidator implements Validator {

	public boolean supports(Class<?> clazz) {
		return Car.class.equals(clazz);
	}

	public void validate(Object target, Errors errors) {
		Car car = (Car) target;
		if(car.getColor()== null){
			errors.rejectValue(	"color", "valid.color","fuck");
		}
		if(car.getRegNumber().isEmpty()){
			errors.rejectValue("regNumber", null,"fuck");
		}
		if(car.getDayPrice()== 0){
			//errors.rejectValue("dayPrice", "valid.dayPrice");
		}
		if(car.getGearBox()== null){
			//errors.rejectValue("gearBox", "valid.gearBox");
		}
		if(car.getModel()== null){
			//errors.rejectValue("model", "valid.model");
		}
		if(car.getSeats()== 0){
			//errors.rejectValue("seats", "valid.seats");
		}
				
		
	}

}
