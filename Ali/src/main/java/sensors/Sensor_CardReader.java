package sensors;

public class Sensor_CardReader extends Sensor{
	public Sensor_CardReader(byte[] senserData,String gatewayIp) {
		SenserName = SenserType.SENSERTYPE_CARDREADER;
		initUniversalData(senserData);
}
}
