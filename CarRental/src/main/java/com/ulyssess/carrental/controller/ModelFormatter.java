package com.ulyssess.carrental.controller;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import com.ulyssess.carrental.entity.Model;
import com.ulyssess.carrental.service.ModelService;

@Component
public class ModelFormatter implements Formatter<Model> {
     @Autowired
     private ModelService modelService;
     //Some service class which can give the Actor after
     //fetching from Database
 
    
     public String print(Model model, Locale arg1) {
           return model.getModelName().toString();
     }
 
     
     public Model parse(String id, Locale arg1) throws ParseException {
          return modelService.findById(id);
          //Else you can just return a new object by setting some values
           //which you deem fit.
     }
}
