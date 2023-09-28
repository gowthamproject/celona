package com.wipro.celona.model;

public class Throughput {
	private String parentId = null;
	private String datetime;
	private double uplink;
	private double downlink;

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getDatetime() {
		return datetime;
	}

	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}

	public double getUplink() {
		return uplink;
	}

	public void setUplink(double uplink) {
		this.uplink = uplink;
	}

	public double getDownlink() {
		return downlink;
	}

	public void setDownlink(double downlink) {
		this.downlink = downlink;
	}

	@Override
	public String toString() {
		return "Throughput [parentId=" + parentId + ", datetime=" + datetime + ", uplink=" + uplink + ", downlink="
				+ downlink + "]";
	}

}
