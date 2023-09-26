package com.wipro.celona.model;

public class Site {
	
	private int id;
	
	private String name;
	
	private int customer_id;
	
	private String country;
		
	private String full_address;
	
	private double map_lat;
	
	private double map_long;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getFull_address() {
		return full_address;
	}

	public void setFull_address(String full_address) {
		this.full_address = full_address;
	}

	public double getMap_lat() {
		return map_lat;
	}

	public void setMap_lat(double map_lat) {
		this.map_lat = map_lat;
	}

	public double getMap_long() {
		return map_long;
	}

	public void setMap_long(double map_long) {
		this.map_long = map_long;
	}
		

}
