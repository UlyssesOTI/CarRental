package com.ulyssess.carrental.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ulyssess.carrental.entity.Mark;
import com.ulyssess.carrental.service.MarkService;

@Controller
public class MarkController {
	
	@Autowired
	private MarkService markService;
	
	@RequestMapping(value="/managerAllMarks")
	private String allModels(Model model){
		model.addAttribute("marks",markService.findAll());
		return "mark-all";
	}
	
	@RequestMapping(value="/managerNewMark")
	private String newModel(Model model){	
		Mark mark = new Mark();
		model.addAttribute("mark",mark);
		return "mark-new";
	}
	
	@RequestMapping(value="/managerEditMark")
	private String editModel(Model model,@RequestParam(value="id") String id){	
		Mark mark = markService.findById(id);
		model.addAttribute("mark",mark);
		return "mark-edit";
	}

//	@RequestMapping(value="/editMark")
//	private String editModel(Model model,@RequestParam(value="id") String id){	
//		Mark mark = markService.findById(id);
//		String operation = "update";
//		if(mark==null){
//			mark = new Mark();
//			operation = "add";
//		}
//		model.addAttribute("mark",mark);
//		model.addAttribute("operation",operation);
//		return "mark-edit";
//	}

	
	@RequestMapping(value="/managerSaveMark")
	private String saveMark(
					@ModelAttribute(value="mark") @Valid Mark mark,
					@RequestParam(value="operation") String operation,
					BindingResult bindingResult, 
					Model model ){
		
		String returnVal = "redirect:/allMarks";
		if(bindingResult.hasErrors()){
			returnVal = "redirect/newMark";
		}else{
			if(operation.equals("add")){
				markService.add(mark);
			}else if(operation.equals("update")){
				markService.update(mark);
			}else if(operation.equals("remove")){
				
			}
		}
		return returnVal;
	}
}
