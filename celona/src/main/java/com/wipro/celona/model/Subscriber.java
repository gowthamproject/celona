package com.wipro.celona.model;

public class Subscriber {

	private int id;

	private String description;

	private int customer_id;

	private String op_status_name;

	private String imei;

	private String imsi;

	private String ip_address;

	private String mac_address;

	private String enodeb_id;

	private String enodeb_name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	public String getOp_status_name() {
		return op_status_name;
	}

	public void setOp_status_name(String op_status_name) {
		this.op_status_name = op_status_name;
	}

	public String getImei() {
		return imei;
	}

	public void setImei(String imei) {
		this.imei = imei;
	}

	public String getImsi() {
		return imsi;
	}

	public void setImsi(String imsi) {
		this.imsi = imsi;
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

	public String getEnodeb_id() {
		return enodeb_id;
	}

	public void setEnodeb_id(String enodeb_id) {
		this.enodeb_id = enodeb_id;
	}

	public String getEnodeb_name() {
		return enodeb_name;
	}

	public void setEnodeb_name(String enodeb_name) {
		this.enodeb_name = enodeb_name;
	}

}
