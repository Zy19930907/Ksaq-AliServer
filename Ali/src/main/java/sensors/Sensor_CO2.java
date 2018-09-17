package sensors;

public class Sensor_CO2 extends Sensor{
	public Sensor_CO2(byte[] senserData,String gatewayIp) {
		SenserName = SenserType.SENSERTYPE_CO2;
		initUniversalData(senserData);
		getConcentration(senserData,"%");
}
}
