package com.ulyssess.carrental.service.implementation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ulyssess.carrental.dao.CarDAO;
import com.ulyssess.carrental.dao.ModelDAO;
import com.ulyssess.carrental.dto.CarAllPageDTO;
import com.ulyssess.carrental.entity.Car;
import com.ulyssess.carrental.entity.Model;
import com.ulyssess.carrental.enums.Color;
import com.ulyssess.carrental.enums.GearBox;
import com.ulyssess.carrental.service.CarService;

@Service
public class CarServiceImpl implements CarService{
	
	@Autowired
	private CarDAO carDAO;
	@Autowired
	private ModelDAO modeldao;

	@Transactional
	public void add(String regNumber, String regDate, String seats, String gearBox, String color, String dayPrice,String modelId) {
		
		if(regNumber != null && seats != null && gearBox != null && color != null && dayPrice != null){
			Car car = new Car(
					regNumber, 
					new Date(), 
					Integer.parseInt(seats), 
					GearBox.valueOf(gearBox),
					Color.valueOf(color),
					Double.parseDouble(dayPrice));
			car.setModel(modeldao.findByKey(Model.class,Integer.parseInt(modelId)));
			carDAO.add(car);
		} else {
			System.out.println("some of parameters are empty"); 
		}
	}

	@Transactional
	public void update(String regNumber, String regDate, String seats, String gearBox, String color, String dayPrice) {
		if(regNumber != null){
			Car carToUpdate = carDAO.findByRegNumber(regNumber);
			if(carToUpdate != null){
//				carToUpdate.set
//				carDAO()
			}else{
				System.out.println("thre is no such car");
			}
		}
		else{
			System.out.println("regnumber is empty");
		}
		
		
	}

	@Transactional
	public List<CarAllPageDTO> findAll() {
		List<CarAllPageDTO> CarToPage = new ArrayList<CarAllPageDTO>();
		List<Car> allCars = carDAO.findAll(Car.class);
		for (Car car : allCars) {
			CarToPage.add(
					new CarAllPageDTO(
							car.getId(),
							car.getRegNumber(),
							car.getRegDate().toString(),
							car.getSeats(),
							car.getDayPrice(),
							car.getGearBox().toString(),
							car.getColor().toString(),
							car.getModel().getModelName()));
		}
		return CarToPage;
	}

	

}
