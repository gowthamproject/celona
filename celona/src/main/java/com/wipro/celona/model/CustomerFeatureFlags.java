package com.wipro.celona.model;

public class CustomerFeatureFlags {
	
	private String flagId;
	
	private String flagName;
	
	private boolean flagStatus;
	
	private String flagType;
	
	private String scoop;
	
	private boolean enabled;

	public String getFlagId() {
		return flagId;
	}

	public void setFlagId(String flagId) {
		this.flagId = flagId;
	}

	public String getFlagName() {
		return flagName;
	}

	public void setFlagName(String flagName) {
		this.flagName = flagName;
	}

	public boolean isFlagStatus() {
		return flagStatus;
	}

	public void setFlagStatus(boolean flagStatus) {
		this.flagStatus = flagStatus;
	}

	public String getFlagType() {
		return flagType;
	}

	public void setFlagType(String flagType) {
		this.flagType = flagType;
	}

	public String getScoop() {
		return scoop;
	}

	public void setScoop(String scoop) {
		this.scoop = scoop;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
}
