package com.ulyssess.carrental.service.implementation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.ArrayUtils;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ulyssess.carrental.controller.DateParse;
import com.ulyssess.carrental.dao.CarDAO;
import com.ulyssess.carrental.dao.ModelDAO;
import com.ulyssess.carrental.dto.ModelAllPageDTO;
import com.ulyssess.carrental.entity.Car;
import com.ulyssess.carrental.entity.Model;
import com.ulyssess.carrental.enums.GearBox;
import com.ulyssess.carrental.service.ModelService;

@Service
public class ModelServiceImpl implements ModelService{
	
	@Autowired
	private ModelDAO modelDAO; 
	
	@Autowired
	private CarDAO carDAO;
		
	@Transactional
	public Model findById(String Id) {
		int id=0;
		Model carModel = null;
		try {
			id = Integer.parseInt(Id);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		if(id != 0){
			carModel = modelDAO.findByKey(Model.class, id);
		}
		return carModel;
	}

	@Transactional
	public List<Model> findAll() {
		return modelDAO.findAll(Model.class);
	}
	
	@Transactional
	public List<ModelAllPageDTO> findAllDTO(HttpServletRequest request) throws IOException{
		List<ModelAllPageDTO> modelToPage = new ArrayList<ModelAllPageDTO>();
		List<Model> allModels = modelDAO.findAll(Model.class);
		for (Model model : allModels) {
			
			
			
			modelToPage.add(
					new ModelAllPageDTO(model.getId(),
							model.getSeats(),
							model.getDayPrice(), 
							model.getGearBox().toString(),
							model.getModelName(),
							model.getMark().getMarkName(),
							"",model.getImageURL()));
		}
		return modelToPage;
	}
	
	/*@Transactional
	public List<ModelAllPageDTO> findAllDTO(HttpServletRequest request) throws IOException{
		List<ModelAllPageDTO> modelToPage = new ArrayList<ModelAllPageDTO>();
		List<Model> allModels = modelDAO.findAll(Model.class);
		for (Model model : allModels) {
			String fullPath = request.getSession().getServletContext().getRealPath("tmp/images");
			List<Byte> byteList = new ArrayList<Byte>();
			try {
				
				FileInputStream fis = new FileInputStream(fullPath+"/"+model.getModelName()+".jpg");
				int c;
				while((c =  fis.read()) != -1){
					byteList.add((byte)c);
				}
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			Byte[] encodeBase64;
			byte[] encodeBase64b;			
			encodeBase64 =  byteList.toArray(new Byte[byteList.size()]); 
			encodeBase64b = Base64.encodeBase64(ArrayUtils.toPrimitive(encodeBase64));
			String base64Encoded = "";
			if(encodeBase64!= null){
				try {
					base64Encoded = new String(encodeBase64b, "UTF-8");
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}
			modelToPage.add(
					new ModelAllPageDTO(model.getId(),
							model.getSeats(),
							model.getDayPrice(), 
							model.getGearBox().toString(),
							model.getModelName(),
							model.getMark().getMarkName(),
							base64Encoded));
		}
		return modelToPage;
	}*/
	
	@Transactional
	public List<ModelAllPageDTO> findAvailableModelsByPeriod(String begin, String end,String markId,String gearBoxId,String minPrice,String maxPrice){
		List<ModelAllPageDTO> modelToPage = new ArrayList<ModelAllPageDTO>();
		Date beginDate = DateParse.parse(begin);
		Date endDate = DateParse.parse(end);
		//Set<Model> resSet = new LinkedHashSet<Model>();
		int idMark = Integer.parseInt(markId);
		
		
		List<Model> models = carDAO.findByAll(idMark, gearBoxId,  Double.parseDouble(maxPrice), Double.parseDouble(minPrice),beginDate, endDate);
		
		/*for (Car car : allCars) {
				resSet.add(car.getModel());			
		}	*/
		for (Model model : models) {
			byte[] encodeBase64 = Base64.encodeBase64(model.getImage());
			String base64Encoded = "";
			if(encodeBase64!= null){
				try {
					base64Encoded = new String(encodeBase64, "UTF-8");
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}
			modelToPage.add(new ModelAllPageDTO(model.getId(),
					model.getSeats(),
					model.getDayPrice(), 
					model.getGearBox().toString(),
					model.getModelName(),
					model.getMark().getMarkName(),
					base64Encoded,model.getImageURL()));
		}
		return modelToPage;
	}

	@Transactional
	public void add(Model model) {
		modelDAO.add(model);
	}

	@Transactional
	public void update(Model model) {
		modelDAO.update(model);
	}

	@Transactional
	public Model findByIdForEdit(String Id) {
		int id=0;
		Model carModel = null;
		try {
			id = Integer.parseInt(Id);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		if(id != 0){
			
			carModel = modelDAO.findByKey(Model.class, id);
			if(carModel!=null){
				
			}
			Hibernate.initialize(carModel.getId());
			Hibernate.initialize(carModel.getImage());
			Hibernate.initialize(carModel.getDayPrice());
			Hibernate.initialize(carModel.getGearBox());
			Hibernate.initialize(carModel.getCars());
			Hibernate.initialize(carModel.getMark());
			Hibernate.initialize(carModel.getModelClass());
			Hibernate.initialize(carModel.getModelName());
			Hibernate.initialize(carModel.getReservations());
			Hibernate.initialize(carModel.getSeats());
		}
		Hibernate.initialize(carModel);
		return carModel;
	}
}
