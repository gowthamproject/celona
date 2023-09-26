package com.wipro.celona.model;

import java.util.List;

public class GNB {
	
	private int id;

	private String name;
	
	private String ip_address;
		
	private String mac_address;
	
	private String plmn_id;
	
	private String plmn_name;
	
	private int site_id;
	
	private String map_lat;
	
	private String map_long;
	
	private String state;
	
	private List<Radios> radios;

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

	public String getIp_address() {
		return ip_address;
	}

	public void setIp_address(String ip_address) {
		this.ip_address = ip_address;
	}

	public String getMac_address() {
		return mac_address;
	}

	public void setMac_address(String mac_address) {
		this.mac_address = mac_address;
	}

	public String getPlmn_id() {
		return plmn_id;
	}

	public void setPlmn_id(String plmn_id) {
		this.plmn_id = plmn_id;
	}

	public int getSite_id() {
		return site_id;
	}

	public void setSite_id(int site_id) {
		this.site_id = site_id;
	}

	public String getPlmn_name() {
		return plmn_name;
	}

	public void setPlmn_name(String plmn_name) {
		this.plmn_name = plmn_name;
	}

	public String getMap_lat() {
		return map_lat;
	}

	public void setMap_lat(String map_lat) {
		this.map_lat = map_lat;
	}

	public String getMap_long() {
		return map_long;
	}

	public void setMap_long(String map_long) {
		this.map_long = map_long;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public List<Radios> getRadios() {
		return radios;
	}

	public void setRadios(List<Radios> radios) {
		this.radios = radios;
	}
    
}
