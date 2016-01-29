package com.ulyssess.carrental.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.ulyssess.carrental.dto.ModelAllPageDTO;
import com.ulyssess.carrental.entity.Model;

public interface ModelService {
	
	public void add(Model model);
	
	public void update(Model model);
	
	public Model findById(String Id);
	
	public Model findByIdForEdit(String Id);
	
	public List<Model> findAll();
	
	public List<ModelAllPageDTO> findAllDTO(HttpServletRequest request) throws IOException;
	
	public List<ModelAllPageDTO> findAvailableModelsByPeriod(String begin, String end,String markId,String gearBoxId,String minPrice,String maxPrice);

}
