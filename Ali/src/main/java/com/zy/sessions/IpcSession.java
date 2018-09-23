package com.zy.sessions;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import com.zy.beans.SensorBean;
import com.zy.sendobjs.SendToWanDiao;
import com.zy.tools.DataSwitch;
import com.zy.tools.DateTool;
import com.zy.tools.JsonMaker;

import Ali.Ali.App;
import sensors.Sensor;
import sensors.SensorFactory;

public class IpcSession {
	private OutputStream outputStream;
	private InputStream inputStream;
	private Socket socket;
	private volatile boolean listen = true;

	public IpcSession(Socket socket) {
		try {
			this.socket = socket;
			outputStream = socket.getOutputStream();
			inputStream = socket.getInputStream();
			new DataRecv().start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void SendData(byte[] data) {
		if (outputStream != null) {
			try {
				outputStream.write(data, 0, data.length);
				outputStream.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public int freshMode(byte[] senserAck, String gatewayIp) {
		byte[] senserbuf = new byte[5];
		SensorFactory sensorFactory = new SensorFactory();
		SensorBean sensorBean = null;
		JsonMaker jsonMaker = new JsonMaker();
		Sensor senser;
		SendToWanDiao sendToWanDiao = new SendToWanDiao();
		int SenserCnt;
		int i = 0, j = 0;
		SenserCnt = (((DataSwitch.abs(senserAck[11]) * 256) + DataSwitch.abs(senserAck[10])) - 11) / 5;

		for (i = 0; i < SenserCnt; i++) {
			for (j = 0; j < 5; j++)
				senserbuf[j] = senserAck[20 + 5 * i + j];
			senser = sensorFactory.creatSenser(senserbuf, gatewayIp);
			sensorBean = null;
			sensorBean = new SensorBean();
			sensorBean.setSensorName(senser.SenserName);
			sensorBean.setSensorAddr(senser.senserAddr);
			sensorBean.setLinkState(senser.linkState);
			sensorBean.setCanCode("C"+senser.canCode);
			sensorBean.setValue(senser.listenValue);
//			App.logRecoder.saveLog(System.getProperty("user.dir")+"/history/"+senser.SenserName+"/"
//					+senser.senserAddr+"/value"+App.dateTool.getTimeH()+".txt",App.dateTool.getTimeHMS()+":"+senser.listenValue + "\r\n");
			sendToWanDiao.addSensor(sensorBean);
		}
		
		String toWandiao = jsonMaker.BeanToJsonString(sendToWanDiao);
		App.logRecoder.saveLogwd(System.getProperty("user.dir")+"/test.txt",toWandiao);
		return SenserCnt;
	}
	
	public class DataRecv extends Thread {
		private int recvLen;
		private byte[] recv = new byte[10240];
		private byte[] msg;
		private byte[] data;
		private byte[] ack = {0,1,2,3};

		@Override
		public void run() {
			System.out.println("正在监听：" + socket.getInetAddress().toString());
			while (listen) {
				try {
					if ((recvLen = inputStream.read(recv, 0, 10240)) != -1) {
						msg = null;
						msg = new byte[recvLen];
						System.arraycopy(recv,0,msg,0,recvLen);
						if ((DataSwitch.abs(msg[0]) == 0xEF) && (DataSwitch.abs(msg[1]) == 0xEF)
								&& (DataSwitch.abs(msg[2]) == 0xEF) && (DataSwitch.abs(msg[3]) == 0xEF)) {
							switch (msg[9]) {
							case 0x60:
//								App.logRecoder.saveLog(
//										System.getProperty("user.dir") + "/DataLogs/"
//												+ socket.getInetAddress().toString() + "/" + App.dateTool.getTimeH()
//												+ "/GatawayData.txt",
//												App.dateTool.getTimeHMSS() + DataSwitch.bytesToHexString(msg) + "\r\n");
								freshMode(msg, "0.0.0.0:5000");
								SendData(ack);
								break;
							}
						}
					}
				} catch (IOException e) {
					listen = false;
					e.printStackTrace();
				}
			}
		}
	}
}
