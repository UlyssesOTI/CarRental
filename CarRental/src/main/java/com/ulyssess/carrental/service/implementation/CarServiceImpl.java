package com.ulyssess.carrental.service.implementation;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ulyssess.carrental.dao.CarDAO;
import com.ulyssess.carrental.dto.CarAllPageDTO;
import com.ulyssess.carrental.entity.Car;
import com.ulyssess.carrental.service.CarService;

@Service
public class CarServiceImpl implements CarService{
	
	@Autowired
	private CarDAO carDAO;
	
	@Transactional
	public void add(Car car) {
		if(car != null){
			carDAO.add(car);
		}	
	}

	@Transactional
	public void update(Car car) {
		if(car != null){
			carDAO.update(car);
		}	
	}

	@Transactional
	public List<CarAllPageDTO> findAllDTO() {
		List<CarAllPageDTO> CarToPage = new ArrayList<CarAllPageDTO>();
		List<Car> allCars = carDAO.findAll(Car.class);
		for (Car car : allCars) {
			byte[] encodeBase64 = Base64.encodeBase64(car.getModel().getImage());
			String base64Encoded = "";
			if(encodeBase64!= null){
				try {
					base64Encoded = new String(encodeBase64, "UTF-8");
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}
			
			CarToPage.add(
					new CarAllPageDTO(
							car.getId(),
							car.getModel().getMark().getMarkName(),
							car.getRegNumber(),
							car.getRegDate().toString(),
							car.getModel().getSeats(),
							car.getModel().getDayPrice(),
							car.getModel().getGearBox().toString(),
							car.getColor().toString(),
							car.getModel().getModelName(),
							base64Encoded));
		}
		return CarToPage;
	}
}
