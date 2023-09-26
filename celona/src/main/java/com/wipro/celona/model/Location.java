package com.wipro.celona.model;

public class Location {
	
	private double latitude;
	
	private double longitude;
	
	private String region_state;
	
	private int gnb_id; 
	
	private String gnb_name;
	
	
	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public String getRegion_state() {
		return region_state;
	}

	public void setRegion_state(String region_state) {
		this.region_state = region_state;
	}

	public int getGnb_id() {
		return gnb_id;
	}

	public void setGnb_id(int gnb_id) {
		this.gnb_id = gnb_id;
	}

	public String getGnb_name() {
		return gnb_name;
	}

	public void setGnb_name(String gnb_name) {
		this.gnb_name = gnb_name;
	}

}
