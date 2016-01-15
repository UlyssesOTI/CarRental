package com.ulyssess.carrental.service;

import java.util.List;
import com.ulyssess.carrental.entity.Mark;

public interface MarkService {
	
	public void add(Mark mark);
	
	public void update(Mark mark);
		
	public Mark findById(String Id);
	
	public List<Mark> findAll();
		
}
