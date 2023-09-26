package com.wipro.celona.model;

public class Customer {

	private String company_name;

	private int customer_type_id;

	private String ibn_id;

	private int id;

	private String plmn_id;

	private String plmn_name;

	private String sfdc_id;

	private String created_on;

	private String updated_on;

	private String address;

	private String city;

	private String state;

	private String zip_code;
	
	private CustomerFeatureFlags customerFeatureFlags;

	public String getCompany_name() {
		return company_name;
	}

	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}

	public int getCustomer_type_id() {
		return customer_type_id;
	}

	public void setCustomer_type_id(int customer_type_id) {
		this.customer_type_id = customer_type_id;
	}

	public String getIbn_id() {
		return ibn_id;
	}

	public void setIbn_id(String ibn_id) {
		this.ibn_id = ibn_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPlmn_id() {
		return plmn_id;
	}

	public void setPlmn_id(String plmn_id) {
		this.plmn_id = plmn_id;
	}

	public String getPlmn_name() {
		return plmn_name;
	}

	public void setPlmn_name(String plmn_name) {
		this.plmn_name = plmn_name;
	}

	public String getSfdc_id() {
		return sfdc_id;
	}

	public void setSfdc_id(String sfdc_id) {
		this.sfdc_id = sfdc_id;
	}

	public String getCreated_on() {
		return created_on;
	}

	public void setCreated_on(String created_on) {
		this.created_on = created_on;
	}

	public String getUpdated_on() {
		return updated_on;
	}

	public void setUpdated_on(String updated_on) {
		this.updated_on = updated_on;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip_code() {
		return zip_code;
	}

	public void setZip_code(String zip_code) {
		this.zip_code = zip_code;
	}

	public CustomerFeatureFlags getCustomerFeatureFlags() {
		return customerFeatureFlags;
	}

	public void setCustomerFeatureFlags(CustomerFeatureFlags customerFeatureFlags) {
		this.customerFeatureFlags = customerFeatureFlags;
	}

	@Override
	public String toString() {
		return "Subscriber [company_name=" + company_name + ", customer_type_id=" + customer_type_id + ", ibn_id="
				+ ibn_id + ", id=" + id + ", plmn_id=" + plmn_id + ", plmn_name=" + plmn_name + ", sfdc_id=" + sfdc_id
				+ ", created_on=" + created_on + ", updated_on=" + updated_on + ", address=" + address + ", city="
				+ city + ", state=" + state + ", zip_code=" + zip_code + "]";
	}
	
	

}
