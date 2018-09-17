package sensors;

public class Sensor_LaserCH4 extends Sensor{
	public Sensor_LaserCH4(byte[] senserData,String gatewayIp) {
		SenserName = SenserType.SENSERTYPE_LASERCH4;
		initUniversalData(senserData);
		getConcentration(senserData,"%");
	}
}
