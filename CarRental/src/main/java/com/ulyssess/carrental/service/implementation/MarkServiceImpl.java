package com.ulyssess.carrental.service.implementation;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ulyssess.carrental.dao.MarkDAO;
import com.ulyssess.carrental.entity.Mark;
import com.ulyssess.carrental.service.MarkService;

@Service
public class MarkServiceImpl implements MarkService{
	
	@Autowired
	MarkDAO markDAO;
	
	@Transactional
	public void add(Mark mark) {
		markDAO.add(mark);		
	}

	@Transactional
	public void update(Mark mark) {
		markDAO.update(mark);		
	}

	@Transactional
	public Mark findById(String Id) {
		int id=0;
		Mark mark = null;
		try {
			id = Integer.parseInt(Id);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		if(id != 0){
			mark = markDAO.findByKey(Mark.class, id);
		}
		return mark;
	}

	@Transactional
	public List<Mark> findAll() {
		return markDAO.findAll(Mark.class);
	}

	
}
