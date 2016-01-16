package com.ulyssess.carrental.controller;

import java.util.Date;

public class DateParse {
	public static Date parse(String date){
		if(!date.isEmpty()){
			String[] mdy = date.split("/");
			return new Date(Integer.parseInt(mdy[2]), Integer.parseInt(mdy[0]), Integer.parseInt(mdy[1]));
		}
		return new Date();
	}
}
