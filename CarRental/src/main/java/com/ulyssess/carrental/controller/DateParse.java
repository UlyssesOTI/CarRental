package com.ulyssess.carrental.controller;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DateParse {
	public static Date parse(String date){
		if(!date.isEmpty()){
			String[] mdy = date.split("/");
			return new Date(Integer.parseInt(mdy[2])-1900, Integer.parseInt(mdy[0])-1, Integer.parseInt(mdy[1]));
		}
		return new Date();
	}
	
	public static long getDateDiff(Date date1, Date date2, TimeUnit timeUnit) {
	    long diffInMillies = date2.getTime() - date1.getTime();
	    return timeUnit.convert(diffInMillies,TimeUnit.MILLISECONDS);
	}
}
