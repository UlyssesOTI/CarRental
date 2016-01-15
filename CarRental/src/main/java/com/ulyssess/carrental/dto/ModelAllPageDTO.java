package com.ulyssess.carrental.dto;

public class ModelAllPageDTO {
	
	private int id;
	private int seats;
	private Double dayPrice;
	private String gearBox;
	private String modelName;
	private String image;
	
	public ModelAllPageDTO(int id, int seats, Double dayPrice, String gearBox, String modelName, String image) {
		super();
		this.id = id;
		this.seats = seats;
		this.dayPrice = dayPrice;
		this.gearBox = gearBox;
		this.modelName = modelName;
		this.image = image;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSeats() {
		return seats;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}

	public Double getDayPrice() {
		return dayPrice;
	}

	public void setDayPrice(Double dayPrice) {
		this.dayPrice = dayPrice;
	}

	public String getGearBox() {
		return gearBox;
	}

	public void setGearBox(String gearBox) {
		this.gearBox = gearBox;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	
	
	

}
