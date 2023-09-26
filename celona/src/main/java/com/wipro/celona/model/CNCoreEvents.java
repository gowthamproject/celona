package com.wipro.celona.model;

public class CNCoreEvents {
	
	private String groupType;
	
	private String eventType;
	
	private String eventTypeDesc;
	
	private CellEvents cellevent;

	public String getGroupType() {
		return groupType;
	}

	public void setGroupType(String groupType) {
		this.groupType = groupType;
	}

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public String getEventTypeDesc() {
		return eventTypeDesc;
	}

	public void setEventTypeDesc(String eventTypeDesc) {
		this.eventTypeDesc = eventTypeDesc;
	}

	public CellEvents getCellevent() {
		return cellevent;
	}

	public void setCellevent(CellEvents cellevent) {
		this.cellevent = cellevent;
	}

}
