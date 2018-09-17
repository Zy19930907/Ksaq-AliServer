package sensors;

public class Sensor_O2 extends Sensor{
	public Sensor_O2(byte[] senserData,String gatewayIp) {
		SenserName = SenserType.SENSERTYPE_O2;
		initUniversalData(senserData);
		getConcentration(senserData,"%");
}
}
