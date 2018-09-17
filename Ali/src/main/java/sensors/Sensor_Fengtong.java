package sensors;

public class Sensor_Fengtong extends Sensor{
public Sensor_Fengtong(byte[] senserData,String gatewayIp) {
	SenserName = SenserType.SENSERTYPE_Fengtong;
	initUniversalData(senserData);
	switch (senserData[2]&0x01){
	            case 0x00:
	          	  listenValue ="有风";
	                break;
	            case 0x01:
	          	  listenValue +="无风 ";
	                break;
	        }
}
}
