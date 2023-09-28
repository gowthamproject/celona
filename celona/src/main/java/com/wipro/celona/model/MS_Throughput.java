package com.wipro.celona.model;

public class MS_Throughput {

	private String core_id;
	private int uSessionCount;
	private int dSessionCount;
	private double uTotalBytes;
	private double dTotalBytes;
	private double uThroughput;
	private double dThroughput;

	private double uTotalPackets;
	private double dTotalPackets;

	private double throughput;
	private double totalPackets;
	private double totalBytes;

	private long ts;

	public String getCore_id() {
		return core_id;
	}

	public void setCore_id(String core_id) {
		this.core_id = core_id;
	}

	public int getuSessionCount() {
		return uSessionCount;
	}

	public void setuSessionCount(int uSessionCount) {
		this.uSessionCount = uSessionCount;
	}

	public int getdSessionCount() {
		return dSessionCount;
	}

	public void setdSessionCount(int dSessionCount) {
		this.dSessionCount = dSessionCount;
	}

	public double getuTotalBytes() {
		return uTotalBytes;
	}

	public void setuTotalBytes(double uTotalBytes) {
		this.uTotalBytes = uTotalBytes;
	}

	public double getdTotalBytes() {
		return dTotalBytes;
	}

	public void setdTotalBytes(double dTotalBytes) {
		this.dTotalBytes = dTotalBytes;
	}

	public double getuThroughput() {
		return uThroughput;
	}

	public void setuThroughput(double uThroughput) {
		this.uThroughput = uThroughput;
	}

	public double getdThroughput() {
		return dThroughput;
	}

	public void setdThroughput(double dThroughput) {
		this.dThroughput = dThroughput;
	}

	public double getuTotalPackets() {
		return uTotalPackets;
	}

	public void setuTotalPackets(double uTotalPackets) {
		this.uTotalPackets = uTotalPackets;
	}

	public double getdTotalPackets() {
		return dTotalPackets;
	}

	public void setdTotalPackets(double dTotalPackets) {
		this.dTotalPackets = dTotalPackets;
	}

	public double getThroughput() {
		return throughput;
	}

	public void setThroughput(double throughput) {
		this.throughput = throughput;
	}

	public double getTotalPackets() {
		return totalPackets;
	}

	public void setTotalPackets(double totalPackets) {
		this.totalPackets = totalPackets;
	}

	public double getTotalBytes() {
		return totalBytes;
	}

	public void setTotalBytes(double totalBytes) {
		this.totalBytes = totalBytes;
	}

	public long getTs() {
		return ts;
	}

	public void setTs(long ts) {
		this.ts = ts;
	}

	@Override
	public String toString() {
		return "MS_Throughput [core_id=" + core_id + ", uSessionCount=" + uSessionCount + ", dSessionCount="
				+ dSessionCount + ", uTotalBytes=" + uTotalBytes + ", dTotalBytes=" + dTotalBytes + ", uThroughput="
				+ uThroughput + ", dThroughput=" + dThroughput + ", uTotalPackets=" + uTotalPackets + ", dTotalPackets="
				+ dTotalPackets + ", throughput=" + throughput + ", totalPackets=" + totalPackets + ", totalBytes="
				+ totalBytes + ", ts=" + ts + "]";
	}

}
