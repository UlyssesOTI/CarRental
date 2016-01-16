package com.ulyssess.carrental.dao;

import java.util.Date;
import java.util.List;

import com.ulyssess.carrental.entity.Mark;
import com.ulyssess.carrental.entity.Model;
import com.ulyssess.carrental.enums.ModelClass;

public interface ModelDAO extends EntityDAO<Model, Integer>{

	public List<Model> findByModelClass(ModelClass modelClass);
	
	public List<Model> findByMark(Mark mark);
	
}
