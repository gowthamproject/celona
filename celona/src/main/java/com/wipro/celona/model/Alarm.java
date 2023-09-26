package com.wipro.celona.model;

import com.wipro.celona.common.Constants;
import com.wipro.celona.common.Core5GDetails;

public class Alarm {
    private String node_type = Core5GDetails._5G_CORE;
    private String node_name = Core5GDetails.SYSTEM_NAME;
    private String type;
    private String category;
    private long timestamp;
    private String severity;
    private CNCoreEvents cnCoreEvents;
    private String eventType;
    private String deviceName;
    private String eventTypeDesc;
    private String enbId;
    private String iccid;
    private String host;
    private String alarmStatus  = Constants.ALARM_STATUS[1];
    
	public String getNode_type() {
		return node_type;
	}
	public void setNode_type(String node_type) {
		this.node_type = node_type;
	}
	public String getNode_name() {
		return node_name;
	}
	public void setNode_name(String node_name) {
		this.node_name = node_name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}

	public long getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
	public String getSeverity() {
		return severity;
	}
	public void setSeverity(String severity) {
		this.severity = severity;
	}
	public CNCoreEvents getCnCoreEvents() {
		return cnCoreEvents;
	}
	public void setCnCoreEvents(CNCoreEvents cnCoreEvents) {
		this.cnCoreEvents = cnCoreEvents;
	}
	public String getEventType() {
		return eventType;
	}
	public void setEventType(String eventType) {
		this.eventType = eventType;
	}
	public String getDeviceName() {
		return deviceName;
	}
	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}
	public String getEventTypeDesc() {
		return eventTypeDesc;
	}
	public void setEventTypeDesc(String eventTypeDesc) {
		this.eventTypeDesc = eventTypeDesc;
	}
	public String getEnbId() {
		return enbId;
	}
	public void setEnbId(String enbId) {
		this.enbId = enbId;
	}
	public String getIccid() {
		return iccid;
	}
	public void setIccid(String iccid) {
		this.iccid = iccid;
	}
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public String getAlarmStatus() {
		return alarmStatus;
	}
	public void setAlarmStatus(String alarmStatus) {
		this.alarmStatus = alarmStatus;
	}  
}
