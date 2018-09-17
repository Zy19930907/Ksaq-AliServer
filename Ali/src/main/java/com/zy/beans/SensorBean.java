package com.zy.beans;

public class SensorBean {
	private String SensorName;
	private String SensorAddr;
	private String LinkState;
	private String CanCode;
	private String Value;
	
	public String getCanCode() {
		return CanCode;
	}
	public void setCanCode(String canCode) {
		CanCode = canCode;
	}
	public String getSensorName() {
		return SensorName;
	}
	public void setSensorName(String sensorName) {
		SensorName = sensorName;
	}
	
	public String getSensorAddr() {
		return SensorAddr;
	}
	public void setSensorAddr(String sensorAddr) {
		SensorAddr = sensorAddr;
	}
	public String getLinkState() {
		return LinkState;
	}
	public void setLinkState(String linkState) {
		LinkState = linkState;
	}
	public String getValue() {
		return Value;
	}
	public void setValue(String value) {
		Value = value;
	}
	
}
