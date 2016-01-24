package com.ulyssess.carrental.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Reservation {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private Date date;
	private Date beginDate;
	private Date endDate;
	private Double summ;
	@ManyToOne(cascade={CascadeType.MERGE}, fetch = FetchType.LAZY)
	private Client client;
	@ManyToOne(cascade={CascadeType.MERGE}, fetch = FetchType.LAZY)
	private Model model;
	@OneToOne(mappedBy="reservation", cascade = CascadeType.PERSIST)
	private Contract contract;
	
	public Reservation() {
		super();
	}

	public Reservation(Date date, Date beginDate, Date endDate, Double summ, Client client, Model model) {
		super();
		this.date = date;
		this.beginDate = beginDate;
		this.endDate = endDate;
		this.summ = summ;
		this.client = client;
		this.model = model;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Double getSumm() {
		return summ;
	}

	public void setSumm(Double summ) {
		this.summ = summ;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Model getModel() {
		return model;
	}

	public void setModel(Model model) {
		this.model = model;
	}

	public Contract getContract() {
		return contract;
	}

	public void setContract(Contract contract) {
		this.contract = contract;
	}
		
}
