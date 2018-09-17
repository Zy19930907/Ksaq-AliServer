package sensors;

public class Sensor_CH4_LowHigh extends Sensor{
	public Sensor_CH4_LowHigh(byte[] senserData,String gatewayIp) {
		SenserName = SenserType.SENSERTYPE_CH4HIGHLOW;
		initUniversalData(senserData);
		getConcentration(senserData,"%");
}
}
