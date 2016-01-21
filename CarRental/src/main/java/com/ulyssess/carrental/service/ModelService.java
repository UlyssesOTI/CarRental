package com.ulyssess.carrental.service;

import java.util.List;

import com.ulyssess.carrental.dto.ModelAllPageDTO;
import com.ulyssess.carrental.entity.Model;

public interface ModelService {
	
	public void add(Model model);
	
	public void update(Model model);
	
	public Model findById(String Id);
	
	public Model findByIdForEdit(String Id);
	
	public List<Model> findAll();
	
	public List<ModelAllPageDTO> findAllDTO();
	
	public List<ModelAllPageDTO> findAvailableModelsByPeriod(String begin, String end);

}
