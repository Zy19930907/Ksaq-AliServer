package sensors;

public class Sensor_Dust extends Sensor{
	public Sensor_Dust(byte[] senserData,String gatewayIp){
		SenserName = SenserType.SENSERTYPE_Dust;
		initUniversalData(senserData);
		getConcentration(senserData,"mg/m³");	
}
}
