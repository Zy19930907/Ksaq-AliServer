package sensors;

public class Sensor_Breaker extends Sensor{
	public Sensor_Breaker(byte[] senserData, String gatewayIp) {
		SenserName = SenserType.SENSERTYPE_BREAKER;
		initUniversalData(senserData);
		switch (senserData[2] & 0x03) {
		case 0x00:
			listenValue += "复电 | 有电 ";
			break;
		case 0x01:
			listenValue += "断电 | 有电";
			break;
		case 0x02:
			listenValue += "复电 | 无电";
			break;
		case 0x03:
			listenValue += "断电 | 无电";
			break;
		}
	}
}
