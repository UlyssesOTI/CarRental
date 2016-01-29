package com.ulyssess.carrental.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.ulyssess.carrental.enums.GearBox;
import com.ulyssess.carrental.enums.ModelClass;

@Entity
public class Model {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String modelName;
	private int seats;
	private GearBox gearBox;
	private double dayPrice;
	@Lob
	private byte[] image;
	
	private String imageURL;
	private ModelClass modelClass;
	@ManyToOne(cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	private Mark mark;
	@OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY, mappedBy = "model")
	private List<Car> cars;
	@OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY, mappedBy = "model")
	private List<Reservation> reservations;
	
	
	public Model() {
		
	}
		
	public Model(String modelName, byte[] image,String imageURL, ModelClass modelClass, Mark mark) {
		super();
		this.modelName = modelName;
		this.image = image;
		this.modelClass = modelClass;
		this.mark = mark;
		this.imageURL = imageURL;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
	
	public int getSeats() {
		return seats;
	}

	public GearBox getGearBox() {
		return gearBox;
	}

	public void setGearBox(GearBox gearBox) {
		this.gearBox = gearBox;
	}
	
	public double getDayPrice() {
		return dayPrice;
	}

	public void setDayPrice(double dayPrice) {
		this.dayPrice = dayPrice;
	}
	
	public void setSeats(int seats) {
		this.seats = seats;
	}

	public ModelClass getModelClass() {
		return modelClass;
	}

	public void setModelClass(ModelClass modelClass) {
		this.modelClass = modelClass;
	}

	public Mark getMark() {
		return mark;
	}

	public void setMark(Mark mark) {
		this.mark = mark;
	}

	public List<Car> getCars() {
		return cars;
	}

	public void setCars(List<Car> cars) {
		this.cars = cars;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public List<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}

	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}
		
}
