package sensors;

import com.zy.tools.DataSwitch;

public class Sensor_Unknown extends Sensor{
	public Sensor_Unknown(byte[] senserData,String gatewayIp) {
		initUniversalData(senserData);
		if(senserData[1] == ((byte)0xFF))
			listenValue = "";
		else
		{	
			SenserName = SenserType.SENSERTYPE_UNKONOW;
			listenValue= "未定义设备，设备类型码："+ DataSwitch.byteToHexString(senserData[1]);
		}
}
}
