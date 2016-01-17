package com.ulyssess.carrental.controller;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

@Component
public class DoubleFormatter implements Formatter<Double>{

	public String print(Double object, Locale locale) {
		return object.toString();
	}

	public Double parse(String text, Locale locale) throws ParseException {
		return Double.parseDouble(text);
	}

}
