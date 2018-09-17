package sensors;

public class Sensor_PekingPower extends Sensor{
	public Sensor_PekingPower(byte[] senserData,String gatewayIp) {
		SenserName = SenserType.SENSERTYPE_PKPOWER;
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
