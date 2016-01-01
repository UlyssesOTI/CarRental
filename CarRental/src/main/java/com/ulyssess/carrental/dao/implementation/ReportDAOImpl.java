package com.ulyssess.carrental.dao.implementation;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.ulyssess.carrental.dao.ReportDAO;
import com.ulyssess.carrental.entity.Report;

@Repository
public class ReportDAOImpl extends EntityDAOAbstract<Report, Integer> implements ReportDAO{
	
	@PersistenceContext(unitName = "Primary")
	private EntityManager entityManager;

	@Transactional
	public List<Report> findByReportDatePeriod(Date begin, Date end) {
		
		List<Report> resList = null;
		
		resList = entityManager.
				createQuery("SELECT "
						+ "		r "
						+ "	FROM Report r "
						+ "		WHERE (r.date BETWEEN :start AND :end) ",
							Report.class).
				setParameter("start", begin).
				setParameter("end", end).
				getResultList();
				
		return resList;
	}
		
}
