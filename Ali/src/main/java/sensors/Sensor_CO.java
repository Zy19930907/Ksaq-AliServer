package sensors;

public class Sensor_CO extends Sensor{
	public Sensor_CO(byte[] senserData,String gatewayIp) {
		SenserName = SenserType.SENSERTYPE_CO;
		initUniversalData(senserData);
		getConcentration(senserData,"ppm");
}
}
