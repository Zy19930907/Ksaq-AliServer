package sensors;

public class Sensor_IPD_ZJM extends Sensor{
	public Sensor_IPD_ZJM(byte[] senserData,String gatewayIp) {
		SenserName = SenserType.SENSERTYPE_IPD_ZJM;
		initUniversalData(senserData);
}
}
