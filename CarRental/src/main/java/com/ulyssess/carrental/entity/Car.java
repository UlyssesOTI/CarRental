package com.ulyssess.carrental.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


import com.ulyssess.carrental.enums.Color;


@Entity
public class Car {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String regNumber;
	private Date regDate;
	
	
	private Color color;
	@ManyToOne(cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	private Model model;
	@OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.LAZY, mappedBy = "car")
	private List<Contract> contracts;
	
	public Car() {
		// TODO Auto-generated constructor stub
	}
	
	public Car(String regNumber, Date regDate, Color color) {
		super();
		this.regNumber = regNumber;
		this.regDate = regDate;
		this.color = color;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRegNumber() {
		return regNumber;
	}

	public void setRegNumber(String regNumber) {
		this.regNumber = regNumber;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	

	public Model getModel() {
		return model;
	}

	public void setModel(Model model) {
		this.model = model;
	}

	public List<Contract> getContracts() {
		return contracts;
	}

	public void setContracts(List<Contract> contracts) {
		this.contracts = contracts;
	}



	@Override
	public String toString() {
		return "Car [regNumber=" + regNumber + ", regDate=" + regDate + ", color=" + color + "]";
	}



	

	
	
	
}
