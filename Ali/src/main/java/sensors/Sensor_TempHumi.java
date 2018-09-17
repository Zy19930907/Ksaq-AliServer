package sensors;

public class Sensor_TempHumi extends Sensor{
	public Sensor_TempHumi(byte[] senserData,String gatewayIp) {
		SenserName = SenserType.SENSERTYPE_TEMPHUMI;
		initUniversalData(senserData);
		getConcentration(senserData,"°C");
}
}
