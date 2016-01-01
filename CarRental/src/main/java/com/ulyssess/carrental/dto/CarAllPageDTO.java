package com.ulyssess.carrental.dto;



public class CarAllPageDTO {
	
	private int id;
	private String regNumber;
	private String regDate;
	private int seats;
	private Double dayPrice;
	private String gearBox;
	private String color;
	private String modelName;
	
	public CarAllPageDTO() {
		
	}
	
	
	


	public CarAllPageDTO(int id, String regNumber, String regDate, int seats, Double dayPrice, String gearBox,
			String color, String modelName) {
		super();
		this.id = id;
		this.regNumber = regNumber;
		this.regDate = regDate;
		this.seats = seats;
		this.dayPrice = dayPrice;
		this.gearBox = gearBox;
		this.color = color;
		this.modelName = modelName;
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
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public int getSeats() {
		return seats;
	}
	public void setSeats(int seats) {
		this.seats = seats;
	}
	public String getGearBox() {
		return gearBox;
	}
	public void setGearBox(String gearBox) {
		this.gearBox = gearBox;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}


	public String getModelName() {
		return modelName;
	}


	public void setModelName(String modelName) {
		this.modelName = modelName;
	}


	public Double getDayPrice() {
		return dayPrice;
	}


	public void setDayPrice(Double dayPrice) {
		this.dayPrice = dayPrice;
	}

	
}
