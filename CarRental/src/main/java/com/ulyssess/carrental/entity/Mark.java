package com.ulyssess.carrental.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Mark {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String markName;
	@OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY,mappedBy = "mark")
	private List<Model> models;
	
	public Mark() {
		// TODO Auto-generated constructor stub
	}
	
	public Mark(String markName) {
		this.markName = markName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMarkName() {
		return markName;
	}

	public void setMarkName(String markName) {
		this.markName = markName;
	}

	public List<Model> getModels() {
		return models;
	}

	public void setModels(List<Model> models) {
		this.models = models;
	}

	@Override
	public String toString() {
		return "Mark [id=" + id + ", markName=" + markName + "]";
	}
	
}
