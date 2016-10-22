package com.example.ashow;

public class list_item {
	private int Id;
	private int Connected;
	private String GainTime;
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public int getConnected() {
		return Connected;
	}
	public void setConnected(int  connected) {
		Connected = connected;
	}
	public String getGainTime() {
		return GainTime;
	}
	public void setGainTime(String gainTime) {
		GainTime = gainTime;
	}
	public list_item(int id, int connected, String gainTime) {
		this.Id = id;
		this.Connected = connected;
		this.GainTime = gainTime;
	}
	
	
	
	

}
