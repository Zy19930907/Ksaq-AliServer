package sensors;

public class Sensor_Power extends Sensor{
	public Sensor_Power(byte[] senserData,String gatewayIp) {
		SenserName = SenserType.SENSERTYPE_POWER;
		initUniversalData(senserData);
		switch (senserData[2]&0x01){
	            case 0x00:
	          	  listenValue ="交流";
	                break;
	            case 0x01:
	          	  listenValue ="直流";
	                break;
	        }
}
}
