package com.example.ashow;

public class list_item {
	private int Id;
	private String Connected;
	private String GainTime;
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getConnected() {
		return Connected;
	}
	public void setConnected(String connected) {
		Connected = connected;
	}
	public String getGainTime() {
		return GainTime;
	}
	public void setGainTime(String gainTime) {
		GainTime = gainTime;
	}
	public list_item(int id, String connected, String gainTime) {
		this.Id = id;
		this.Connected = connected;
		this.GainTime = gainTime;
	}
	
	
	
	

}
