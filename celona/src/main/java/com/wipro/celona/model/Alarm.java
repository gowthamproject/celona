package com.wipro.celona.model;

import com.wipro.celona.common.Constants;
import com.wipro.celona.common.Core5GDetails;
import com.wipro.celona.utils.Util;

public class Alarm {
	private int id;
	private String node_type = Core5GDetails._5G_CORE;
	private String node_name = Core5GDetails.SYSTEM_NAME;
	private String type;
	private String category;
	private String host;
	private String ip;
	private String clusterID;
	private long timestamp;
	private String severity;
	private String eventType;
	private String deviceName;
	private String eventTypeDesc;
	private String cell_enbId;
	private String cell_eventType;
	private String cell_description;
	private String uuid;
	private String edgeName;

	private String alarmStatus = Constants.ALARM_STATUS[1];

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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getClusterID() {
		return clusterID;
	}

	public void setClusterID(String clusterID) {
		this.clusterID = clusterID;
	}

	public String getCell_enbId() {
		return cell_enbId;
	}

	public void setCell_enbId(String cell_enbId) {
		this.cell_enbId = cell_enbId;
	}

	public String getCell_eventType() {
		return cell_eventType;
	}

	public void setCell_eventType(String cell_EventType) {
		this.cell_eventType = cell_EventType;
	}

	public String getCell_description() {
		return cell_description;
	}

	public void setCell_description(String cell_description) {
		this.cell_description = cell_description;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getEdgeName() {
		return edgeName;
	}

	public void setEdgeName(String edgeName) {
		this.edgeName = edgeName;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Alarm) {
			Alarm temp = (Alarm) obj;

			/*
			 * if ((this.type != null && this.type.equals(temp.type)) && (this.category !=
			 * null && this.category.equals(temp.category)) && (this.host != null &&
			 * this.host.equals(temp.host)) && (this.ip != null && this.ip.equals(temp.ip))
			 * && (this.clusterID != null && this.clusterID.equals(temp.clusterID)) &&
			 * (this.severity != null && this.severity.equals(temp.severity)) &&
			 * (this.eventType != null && this.eventType.equals(temp.eventType)) &&
			 * (this.deviceName != null && this.deviceName.equals(temp.deviceName)) &&
			 * (this.eventTypeDesc != null && this.eventTypeDesc.equals(temp.eventTypeDesc))
			 * && (this.cell_enbId != null && this.cell_enbId.equals(temp.cell_enbId)) &&
			 * (this.cell_eventType != null &&
			 * this.cell_eventType.equals(temp.cell_eventType)) && (this.cell_description !=
			 * null && this.cell_description.equals(temp.cell_description)) && (this.uuid !=
			 * null && this.uuid.equals(temp.uuid)) && (this.edgeName != null &&
			 * this.edgeName.equals(temp.edgeName))) return true;
			 */

			if ((this.host != null && temp.host != null && this.host.equals(temp.host))
					&& (this.category != null && temp.category != null && this.category.equals(temp.category))
					&& (this.eventType != null && temp.eventType != null && this.eventType.equals(temp.eventType))
					&& (this.type != null && temp.type != null && this.type.equals(temp.type))
					&& (this.ip != null && temp.ip != null && this.ip.equals(temp.ip))
					&& (this.severity != null && temp.severity != null && this.severity.equals(temp.severity))
					&& (this.eventTypeDesc != null && temp.eventTypeDesc != null && this.eventTypeDesc.equals(temp.eventTypeDesc))

					&& (this.clusterID != null && temp.clusterID != null && this.clusterID.equals(temp.clusterID))
					&& (this.deviceName != null && temp.deviceName != null && this.deviceName.equals(temp.deviceName))
					&& (this.cell_enbId != null && temp.cell_enbId != null && this.cell_enbId.equals(temp.cell_enbId))
					
					&& (this.cell_eventType != null && temp.cell_eventType != null && this.cell_eventType.equals(temp.cell_eventType))
					&& (this.cell_description != null && temp.cell_description != null && this.cell_description.equals(temp.cell_description))
					&& (this.uuid != null && temp.uuid != null && this.uuid.equals(temp.uuid))
					&& (this.edgeName != null && temp.edgeName != null && this.edgeName.equals(temp.edgeName))

			)
				return true;
		}
		return false;
	}

	@Override
	public int hashCode() {
		return (this.clusterID.hashCode() + this.edgeName.hashCode() + this.category.hashCode()
				+ this.severity.hashCode() + this.host.hashCode() + this.eventType.hashCode() + this.ip.hashCode()
				+ this.uuid.hashCode() + this.eventTypeDesc.hashCode() + this.cell_eventType.hashCode()
				+ this.cell_description.hashCode() + this.type.hashCode() + this.deviceName.hashCode()
				+ this.cell_enbId.hashCode());
	}

	@Override
	public String toString() {
		return "Alarm [id=" + id + ", node_type=" + node_type + ", node_name=" + node_name + ", type=" + type
				+ ", category=" + category + ", host=" + host + ", ip=" + ip + ", clusterID=" + clusterID
				+ ", timestamp=" + timestamp + ", severity=" + severity + ", eventType=" + eventType + ", deviceName="
				+ deviceName + ", eventTypeDesc=" + eventTypeDesc + ", cell_enbId=" + cell_enbId + ", cell_eventType="
				+ cell_eventType + ", cell_description=" + cell_description + ", uuid=" + uuid + ", edgeName="
				+ edgeName + ", alarmStatus=" + alarmStatus + "]";
	}

}
