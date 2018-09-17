package com.zy.sendobjs;

import java.util.ArrayList;
import java.util.List;

import com.zy.beans.SensorBean;

public class SendToWanDiao {
	
	private List<SensorBean> sensorBeans = new ArrayList<SensorBean>();
	
	public List<SensorBean> getSensorBeans() {
		return sensorBeans;
	}

	public void setSensorBeans(List<SensorBean> sensorBeans) {
		this.sensorBeans = sensorBeans;
	}

	public void ClearBeans() {
		sensorBeans.removeAll(sensorBeans);
	}
	
	public void addSensor(SensorBean bean)
	{
		sensorBeans.add(bean);
	}
}
