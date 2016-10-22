package com.example.ashow;

public class Temp {
	private int Id;
	private int tempId;
	private Double temp;
	public int getTempId() {
		return tempId;
	}
	public void setTempId(int tempId) {
		this.tempId = tempId;
	}
	public Double getTemp() {
		return temp;
	}
	public void setTemp(Double temp) {
		this.temp = temp;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	
	public Temp(int Id, int tempId,Double _temp) {
		this.Id = Id;
		this.tempId = tempId;
		this.temp = _temp;
	}
	

}
