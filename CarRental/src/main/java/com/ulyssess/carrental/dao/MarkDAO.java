package com.ulyssess.carrental.dao;

import java.util.List;

import com.ulyssess.carrental.entity.Mark;

public interface MarkDAO extends EntityDAO<Mark, Integer>{
	
	public List<Mark> findByName(List<String> names);
	
}
