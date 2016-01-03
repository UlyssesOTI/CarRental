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
import com.ulyssess.carrental.enums.GearBox;

@Entity
public class Car {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String regNumber;
	private Date regDate;
	private int seats;
	private GearBox gearBox;
	private Color color;
	private double dayPrice;
	private byte[] image;
	@ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.LAZY)
	private Model model;
	@OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.LAZY, mappedBy = "car")
	private List<Contract> contracts;
	
	public Car() {
		// TODO Auto-generated constructor stub
	}
	
	public Car(String regNumber, Date regDate, int seats, GearBox gearBox, Color color, double dayPrice, byte[] image) {
		super();
		this.regNumber = regNumber;
		this.regDate = regDate;
		this.seats = seats;
		this.gearBox = gearBox;
		this.color = color;
		this.dayPrice = dayPrice;
		this.image = image;
	}

	public int getSeats() {
		return seats;
	}



	public void setSeats(int seats) {
		this.seats = seats;
	}



	public GearBox getGearBox() {
		return gearBox;
	}



	public void setGearBox(GearBox gearBox) {
		this.gearBox = gearBox;
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

	public double getDayPrice() {
		return dayPrice;
	}

	public void setDayPrice(double dayPrice) {
		this.dayPrice = dayPrice;
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
		return "Car [regNumber=" + regNumber + ", regDate=" + regDate + ", seats=" + seats + ", gearBox=" + gearBox
				+ ", color=" + color + ", dayPrice=" + dayPrice + "]";
	}



	public byte[] getImage() {
		return image;
	}



	public void setImage(byte[] image) {
		this.image = image;
	}

	
	
	
}
