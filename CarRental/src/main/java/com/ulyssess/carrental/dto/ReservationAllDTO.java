package com.ulyssess.carrental.dto;



public class ReservationAllDTO {
	
	private Integer id;
	private String date;
	private String beginDate;
	private String endDate;
	private String summ;
	private Integer clientId;
	private String clientLastName;
	private String clientFirstName;
	private Integer modelId;
	private String modelName;
	private Integer contractId;
		
	public ReservationAllDTO(Integer id, String date, String beginDate, String endDate, String summ, Integer clientId,
			String clientLastName, String clientFirstName, Integer modelId, String modelName, Integer contractId) {
		super();
		this.id = id;
		this.date = date;
		this.beginDate = beginDate;
		this.endDate = endDate;
		this.summ = summ;
		this.clientId = clientId;
		this.clientLastName = clientLastName;
		this.clientFirstName = clientFirstName;
		this.modelId = modelId;
		this.modelName = modelName;
		this.contractId = contractId;
	}
	
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
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


	public String getSumm() {
		return summ;
	}


	public void setSumm(String summ) {
		this.summ = summ;
	}


	public Integer getClientId() {
		return clientId;
	}


	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}


	public String getClientLastName() {
		return clientLastName;
	}


	public void setClientLastName(String clientLastName) {
		this.clientLastName = clientLastName;
	}


	public String getClientFirstName() {
		return clientFirstName;
	}


	public void setClientFirstName(String clientFirstName) {
		this.clientFirstName = clientFirstName;
	}


	public Integer getModelId() {
		return modelId;
	}


	public void setModelId(Integer modelId) {
		this.modelId = modelId;
	}


	public String getModelName() {
		return modelName;
	}


	public void setModelName(String modelName) {
		this.modelName = modelName;
	}


	public Integer getContractId() {
		return contractId;
	}


	public void setContractId(Integer contractId) {
		this.contractId = contractId;
	}
	
}
