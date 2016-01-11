package com.ulyssess.carrental.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.ulyssess.carrental.entity.Model;
import com.ulyssess.carrental.service.ModelService;

@Component
public class ModelConverter implements Converter<String, Model>{
	
	@Autowired
	private ModelService modelService;
	
	public Model convert(String id) {
		
		return modelService.findById(id);
	}

}
