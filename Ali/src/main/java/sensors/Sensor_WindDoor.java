package sensors;

public class Sensor_WindDoor extends Sensor{
	public Sensor_WindDoor(byte[] senserData,String gatewayIp) {
		SenserName = SenserType.SENSERTYPE_WINDDOOR;
		initUniversalData(senserData);
		if ((senserData[2] & 0x0F) == 0x02) {
			listenValue = "两风门关闭";
		} else if ((senserData[2] & 0x0F)== 0x03) {
			listenValue = "一开一闭";
		} else if ((senserData[2] & 0x0F) == 0x04) {
			listenValue = "两风门开启";
		} else {
			switch (senserData[2] & 0x01) {
			case 0x00:
				listenValue = "风门开";
				break;
			case 0x01:
				listenValue = "风门关";
				break;
			}
		}
}
}
