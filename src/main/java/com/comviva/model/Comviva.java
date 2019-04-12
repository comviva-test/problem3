package com.comviva.model;

import java.util.Date;

public class Comviva {
	
	private String path;
	private Double value;
	private Date dateTime;
	
	public Comviva(String path, Double value, Date dateTime) {
		super();
		this.path = path;
		this.value = value;
		this.dateTime = dateTime;
	}
	
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public Double getValue() {
		return value;
	}
	public void setValue(Double value) {
		this.value = value;
	}
	public Date getDateTime() {
		return dateTime;
	}
	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}
	
	@Override
	public String toString() {
		return path + " " + value + " " + dateTime;
	}
}
