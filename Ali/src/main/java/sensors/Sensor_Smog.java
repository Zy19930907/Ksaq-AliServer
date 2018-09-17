package sensors;

public class Sensor_Smog extends Sensor{
	public Sensor_Smog(byte[] senserData,String gatewayIp) {
		SenserName = SenserType.SENSERTYPE_SMOG;
		initUniversalData(senserData);
		switch (senserData[2]&0x01){
	            case 0x00:
	          	  listenValue ="有烟";
	                break;
	            case 0x01:
	          	  listenValue ="无烟";
	                break;
		}
}
}
