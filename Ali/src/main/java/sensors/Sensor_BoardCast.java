package sensors;

import com.zy.tools.DataSwitch;

public class Sensor_BoardCast extends Sensor {
	private float Battery;
	private String rs485State;
	private String battery;
	private String buttonState;
	private int volum;
	
	public int getVolum() {
		return volum;
	}
	public void setVolum(int volum) {
		this.volum = volum;
	}
	public String getRs485State() {
		return rs485State;
	}
	public void setRs485State(String rs485State) {
		this.rs485State = rs485State;
	}
	public String getBattery() {
		return battery;
	}
	public void setBattery(String battery) {
		this.battery = battery;
	}
	public String getButtonState() {
		return buttonState;
	}
	public void setButtonState(String buttonState) {
		this.buttonState = buttonState;
	}
	public Sensor_BoardCast(byte[] senserData, String gatewayIp) {
		SenserName = SenserType.SENSERTYPE_BOARDCAST;
		initUniversalData(senserData);
		Battery = DataSwitch.abs(senserData[3]);
		Battery /= 10;
		
		volum = senserData[4];
		switch (senserData[2] & 0x01) {
		case 0x00:
			listenValue = SenserInfo.SENSERSTATE_VOICEWIRESTATE_IDLE;
			buttonState = SenserInfo.SENSERSTATE_VOICEWIRESTATE_IDLE;
			break;
		case 0x01:
			listenValue = SenserInfo.SENSERSTATE_VOICEWIRESTATE_BUSY;
			buttonState = SenserInfo.SENSERSTATE_VOICEWIRESTATE_BUSY;
			break;
		}
		switch (senserData[2] & 0x10) {
		case 0x10:
			listenValue =SenserInfo.SENSERSTATE_VOICEWIRESTATE_Error ;
			rs485State = SenserInfo.SENSERSTATE_VOICEWIRESTATE_Error ;
			break;
		case 0x00:
			rs485State =SenserInfo.SENSERSTATE_VOICEWIRESTATE_Nomal;
			listenValue += SenserInfo.SENSERSTATE_VOICEWIRESTATE_Nomal;
			break;
		}
		battery = String.valueOf(Battery) + "V";
		saveMsg = listenValue + "| 电池电量："+battery;
	}
}
