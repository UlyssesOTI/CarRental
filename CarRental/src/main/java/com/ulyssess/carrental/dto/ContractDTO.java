package com.ulyssess.carrental.dto;



public class ContractDTO {
	
	private int id;
	private String date;
	private String beginDate;
	private String endDate;
	private Double price;
	private String clientInfo;
	private String carInfo;
	private String managerInfo;
	private String reservationInfo;
	
	public ContractDTO(int id, String date, String beginDate, String endDate, Double price, String clientInfo,
			String carInfo, String managerInfo, String reservationInfo) {
		super();
		this.id = id;
		this.date = date;
		this.beginDate = beginDate;
		this.endDate = endDate;
		this.price = price;
		this.clientInfo = clientInfo;
		this.carInfo = carInfo;
		this.managerInfo = managerInfo;
		this.reservationInfo = reservationInfo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(String beginDate) {
		this.beginDate = beginDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getClientInfo() {
		return clientInfo;
	}

	public void setClientInfo(String clientInfo) {
		this.clientInfo = clientInfo;
	}

	public String getCarInfo() {
		return carInfo;
	}

	public void setCarInfo(String carInfo) {
		this.carInfo = carInfo;
	}

	public String getManagerInfo() {
		return managerInfo;
	}

	public void setManagerInfo(String managerInfo) {
		this.managerInfo = managerInfo;
	}

	public String getReservationInfo() {
		return reservationInfo;
	}

	public void setReservationInfo(String reservationInfo) {
		this.reservationInfo = reservationInfo;
	}
	
	
	
}
