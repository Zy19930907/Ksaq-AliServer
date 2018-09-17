package com.zy.sessions;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import org.omg.CORBA.PRIVATE_MEMBER;
import com.zy.beans.SensorBean;
import com.zy.sendobjs.SendToWanDiao;
import com.zy.tools.DataSwitch;
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
		Object[][] sensermsg;
		String[][] msgStrings;
		String[] senserStrings;
		SendToWanDiao sendToWanDiao = new SendToWanDiao();
		int SenserCnt;
		int i = 0, j = 0;
		msgStrings = null;
		sensermsg = null;
		SenserCnt = (((DataSwitch.abs(senserAck[11]) * 256) + DataSwitch.abs(senserAck[10])) - 11) / 5;
		msgStrings = new String[SenserCnt][5];
		sensermsg = new Object[SenserCnt][5];
		senserStrings = new String[SenserCnt];

		for (i = 0; i < SenserCnt; i++) {
			for (j = 0; j < 5; j++)
				senserbuf[j] = senserAck[20 + 5 * i + j];
			senserStrings[i] = DataSwitch.bytesToHexString(senserbuf);
			senser = sensorFactory.creatSenser(senserbuf, gatewayIp);
			msgStrings[i][0] = senser.SenserName;
			msgStrings[i][1] = senser.linkState;
			msgStrings[i][2] = senser.senserAddr;
			msgStrings[i][3] = senser.canCode;
			msgStrings[i][4] = senser.listenValue;
			sensermsg[i] = msgStrings[i];
			sensorBean = null;
			sensorBean = new SensorBean();
			sensorBean.setSensorName(senser.SenserName);
			sensorBean.setSensorAddr(senser.senserAddr);
			sensorBean.setLinkState(senser.linkState);
			sensorBean.setCanCode("C"+senser.canCode);
			sensorBean.setValue(senser.listenValue);
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

		@Override
		public void run() {
			System.out.println("正在监听：" + socket.getInetAddress().toString());
			while (listen) {
				try {
					if ((recvLen = inputStream.read(recv, 0, 10240)) != -1) {
						msg = null;
						msg = new byte[recvLen];
						data = null;
						data = new byte[msg.length - 5];
						System.arraycopy(recv, 0, msg, 0, recvLen);
						System.arraycopy(msg, 5, data, 0, data.length);
						
						if ((DataSwitch.abs(msg[0]) == 0xFE) && (DataSwitch.abs(msg[1]) == 0xFE)
								&& (DataSwitch.abs(msg[2]) == 0xFE) && (DataSwitch.abs(msg[3]) == 0xFE)) {
							switch (msg[4]) {
							case 0x00:
								App.logRecoder.saveLog(
										System.getProperty("user.dir") + "/DataLogs/"
												+ socket.getInetAddress().toString() + "/" + App.dateTool.getTimeH()
												+ "/GatawayData.txt",
												App.dateTool.getTimeHMSS() + DataSwitch.bytesToHexString(data) + "\r\n");
								freshMode(data, "0.0.0.0:5000");
								break;
							case 0x01:
								App.logRecoder.saveLog(
										System.getProperty("user.dir") + "/DataLogs/"
												+ socket.getInetAddress().toString() + "/" + App.dateTool.getTimeH()
												+ "/SwitcherSensorInfo.txt",
												App.dateTool.getTimeHMSS() + DataSwitch.bytesToHexString(data) + "\r\n");
								break;

							case 0x02:
								App.logRecoder.saveLog(
										System.getProperty("user.dir") + "/DataLogs/"
												+ socket.getInetAddress().toString() + "/" + App.dateTool.getTimeH()
												+ "/SwitcherCtrInfo.txt",
												App.dateTool.getTimeHMSS() + DataSwitch.bytesToHexString(data) + "\r\n");
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
