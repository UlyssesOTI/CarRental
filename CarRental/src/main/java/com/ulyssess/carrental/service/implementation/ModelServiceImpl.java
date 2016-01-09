package com.ulyssess.carrental.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ulyssess.carrental.dao.ModelDAO;
import com.ulyssess.carrental.entity.Model;
import com.ulyssess.carrental.service.ModelService;

@Service
public class ModelServiceImpl implements ModelService{
	
	@Autowired
	private ModelDAO modelDAO; 

	@Transactional
	public List<Model> findAllModels() {
		
		return modelDAO.findAll(Model.class);
	}

	@Transactional
	public Model findById(String modelId) {
		int id=0;
		Model carModel = null;
		try {
			id = Integer.parseInt(modelId);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		if(id != 0){
			carModel = modelDAO.findByKey(Model.class, id);
		}
		return carModel;
	}

}
