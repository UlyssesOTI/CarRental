package com.ulyssess.carrental.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.ulyssess.carrental.file.FileClass;
import com.ulyssess.carrental.file.FileValidator;

//@Controller
public class FileController {

//	@Autowired
//	FileValidator validator;
//
//	@InitBinder
//	private void initBinder(WebDataBinder binder) {
//		binder.setValidator(validator);
//	}

//	@RequestMapping(value = "/file", method = RequestMethod.GET)
//	public String getForm(Model model) {
//		FileClass fileModel = new FileClass();
//		model.addAttribute("file", fileModel);
//		return "file";
//	}

	
//	@RequestMapping(value = "/file", method = RequestMethod.POST)
//	public String fileUploaded(
//			Model model,
//			@Validated FileClass file,
//			BindingResult result
//										) throws IOException {
//
//		String returnVal = "redirect:/showAllCars";
//		if (result.hasErrors()) {
//			returnVal = "file";
//		} else {			
//			MultipartFile multipartFile = file.getFile();
//			File convFile = new File(multipartFile.getOriginalFilename());
//		    convFile.createNewFile(); 
//		    FileOutputStream fos = new FileOutputStream(convFile); 
//		    fos.write(multipartFile.getBytes());
//		    fos.close(); 
//		    
//		}
//		return returnVal;
//	}
}