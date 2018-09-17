package sensors;

public class Sensor_WindSpeed extends Sensor{
	public Sensor_WindSpeed(byte[] senserData, String gatewayIp) {
		SenserName = SenserType.SENSERTYPE_WindSpeed;
		initUniversalData(senserData);
		getConcentration(senserData, "m/s");
	}
}
