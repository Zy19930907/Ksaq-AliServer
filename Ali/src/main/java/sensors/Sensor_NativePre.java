package sensors;

public class Sensor_NativePre extends Sensor{
	public Sensor_NativePre(byte[] senserData,String gatewayIp) {
		SenserName = SenserType.SENSERTYPE_NATIVEPRE;
		initUniversalData(senserData);
		getConcentration(senserData,"KPa");
}
}
