package sensors;

public class Sensor_CH4_Low extends Sensor{
	public Sensor_CH4_Low(byte[] senserData,String gatewayIp) {
		SenserName = SenserType.SENSERTYPE_CH4LOW;
		initUniversalData(senserData);
		getConcentration(senserData,"%");
		}
}
