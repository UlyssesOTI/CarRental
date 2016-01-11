package com.ulyssess.carrental.service.implementation;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



import org.apache.commons.codec.binary.Base64;
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
	public void add(Car car) {
		if(car != null){
			carDAO.add(car);
		}
		
	}

//	@Transactional
//	public void add(String regNumber, String regDate, String seats, String gearBox, String color, String dayPrice,String modelId, byte[] image) {
//		
//		if(regNumber != null && seats != null && gearBox != null && color != null && dayPrice != null){
//			Car car = new Car(
//					regNumber, 
//					new Date(), 
//					Integer.parseInt(seats), 
//					GearBox.valueOf(gearBox),
//					Color.valueOf(color),
//					Double.parseDouble(dayPrice),image);
//			car.setModel(modeldao.findByKey(Model.class,Integer.parseInt(modelId)));
//			carDAO.add(car);
//		} else {
//			System.out.println("some of parameters are empty"); 
//		}
//	}
	
	

	@Transactional
	public void update(Car car) {
		if(car != null){
			carDAO.update(car);
		}	
	}

	@Transactional
	public List<CarAllPageDTO> findAll() {
		List<CarAllPageDTO> CarToPage = new ArrayList<CarAllPageDTO>();
		List<Car> allCars = carDAO.findAll(Car.class);
		for (Car car : allCars) {
			byte[] encodeBase64 = Base64.encodeBase64(car.getImage());
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
							car.getRegNumber(),
							car.getRegDate().toString(),
							car.getSeats(),
							car.getDayPrice(),
							car.getGearBox().toString(),
							car.getColor().toString(),
							car.getModel().getModelName(),
							base64Encoded));
		}
		return CarToPage;
	}

	

}
