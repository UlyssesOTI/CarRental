package com.ulyssess.carrental.controller;

import java.io.IOException;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import com.ulyssess.carrental.enums.GearBox;
import com.ulyssess.carrental.service.MarkService;
import com.ulyssess.carrental.service.ModelService;
import com.ulyssess.carrental.validator.FileClass;

@Controller
public class ModelController {

	@Autowired
	private ModelService modelService;
	
	@Autowired
	private MarkService markService;

	
	@RequestMapping(value="/mShowModels")
	private String allModels(Model model){
		model.addAttribute("models",modelService.findAllDTO());
		return "model-all";
	}
	
	@RequestMapping(value="/mCreateModel")
	private String newModel(Model model){
		com.ulyssess.carrental.entity.Model carModel = new com.ulyssess.carrental.entity.Model();
		model.addAttribute("model",carModel);
		model.addAttribute("marks",markService.findAll());
		model.addAttribute("gearBoxs", GearBox.values());
		return "model-new";
	}
		
	@RequestMapping(value="/mEditModel")
	private String editModel(Model model,@RequestParam(value="id") String id){
		com.ulyssess.carrental.entity.Model carModel = modelService.findByIdForEdit(id);
		model.addAttribute("model",carModel);
		model.addAttribute("marks",markService.findAll());
		model.addAttribute("gearBoxs", GearBox.values());
		return "model-edit";
	}
	
	
	@RequestMapping(value="/mSaveModel" ,method = RequestMethod.POST)
	private String saveModel(
			@ModelAttribute("model") @Valid com.ulyssess.carrental.entity.Model carModel, 
			@Validated FileClass file,
			@RequestParam(value="operation") String operation,
			BindingResult result, 
			Model model
			){
		
		String returnVal = "redirect:/mShowModels";
		MultipartFile multipartFile = file.getFile();
		if(result.hasErrors()){
			returnVal = "redirect:/mCreateModel";
		}else{
			byte[] image;
			try {
				if(!multipartFile.isEmpty()){
					image = multipartFile.getBytes();
					carModel.setImage(image);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			if(operation.equals("add")){
				modelService.add(carModel);
			}else if(operation.equals("update")){
				modelService.update(carModel);
			}else if(operation.equals("remove")){
				
			}
			
		}
				
		return returnVal;
	}
}
