package com.ulyssess.carrental.service.implementation;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ulyssess.carrental.dao.ModelDAO;
import com.ulyssess.carrental.dto.ModelAllPageDTO;
import com.ulyssess.carrental.entity.Model;
import com.ulyssess.carrental.service.ModelService;

@Service
public class ModelServiceImpl implements ModelService{
	
	@Autowired
	private ModelDAO modelDAO; 
		
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
	public List<ModelAllPageDTO> findAllDTO(){
		List<ModelAllPageDTO> modelToPage = new ArrayList<ModelAllPageDTO>();
		List<Model> allModels = modelDAO.findAll(Model.class);
		for (Model model : allModels) {
			byte[] encodeBase64 = Base64.encodeBase64(model.getImage());
			String base64Encoded = "";
			if(encodeBase64!= null){
				try {
					base64Encoded = new String(encodeBase64, "UTF-8");
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}
			modelToPage.add(new ModelAllPageDTO(model.getId(), model.getSeats(), model.getDayPrice(), model.getGearBox().toString(), model.getModelName(), base64Encoded));
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
}
