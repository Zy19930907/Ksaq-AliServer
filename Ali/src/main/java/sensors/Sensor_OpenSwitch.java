package sensors;

public class Sensor_OpenSwitch extends Sensor{
	public Sensor_OpenSwitch(byte[] senserData,String gatewayIp) {
		SenserName = SenserType.SENSERTYPE_OPENSWITCH;
		initUniversalData(senserData);
		switch (senserData[2]&0x01){
		            case 0x00:
		          	  listenValue ="开";
		                break;
		            case 0x01:
		          	  listenValue +="停 ";
		                break;
		        }
}
}
