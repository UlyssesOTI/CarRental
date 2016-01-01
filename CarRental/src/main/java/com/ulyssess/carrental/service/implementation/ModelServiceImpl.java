package com.ulyssess.carrental.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ulyssess.carrental.dao.ModelDAO;
import com.ulyssess.carrental.entity.Model;
import com.ulyssess.carrental.service.ModelService;

@Service
public class ModelServiceImpl implements ModelService{
	
	@Autowired
	private ModelDAO modelDAO; 

	public List<Model> findAllModels() {
		
		return modelDAO.findAll(Model.class);
	}

}
