package com.ulyssess.carrental.controller;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import com.ulyssess.carrental.entity.Mark;
import com.ulyssess.carrental.service.MarkService;

@Component
public class MarkFormatter implements Formatter<Mark>{

	@Autowired
	private MarkService markService;
	
	public String print(Mark mark, Locale locale) {
		return mark.getMarkName().toString();
	}

	public Mark parse(String text, Locale locale) throws ParseException {
		return markService.findById(text);
	}

}
