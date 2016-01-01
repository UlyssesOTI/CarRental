package com.ulyssess.carrental.dao;

import java.util.Date;
import java.util.List;

import com.ulyssess.carrental.entity.Report;

public interface ReportDAO extends EntityDAO<Report, Integer>{
	
	public List<Report> findByReportDatePeriod(Date begin, Date end);
		
}
