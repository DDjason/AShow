package com.example.ashow;

public class Temp {
	private int Id;
	private int tempId;
	private String temp;
	public int getTempId() {
		return tempId;
	}
	public void setTempId(int tempId) {
		this.tempId = tempId;
	}
	public String getTemp() {
		return temp;
	}
	public void setTemp(String temp) {
		this.temp = temp;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	
	public Temp(int Id, int tempId,String _temp) {
		this.Id = Id;
		this.tempId = tempId;
		this.temp = _temp;
	}
	

}
