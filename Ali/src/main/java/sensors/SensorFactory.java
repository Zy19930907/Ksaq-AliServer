package sensors;

public class SensorFactory {
	private Sensor_CH4_Low sensor_CH4_Low;
	private Sensor_CH4_LowHigh sensor_CH4_LowHigh;
	private Sensor_Breaker sensor_Breaker;
	private Sensor_OpenSwitch sensor_OpenSwitch;
	private Sensor_Power sensor_Power;
	private Sensor_CO sensor_CO;
	private Sensor_CO2 sensor_CO2;
	private Sensor_CardReader sensor_CardReader;
	private Sensor_BoardCast sensor_BoardCast;
	private Sensor_TempHumi sensor_TempHumi;
	private Sensor_LaserCH4 sensor_LaserCH4;
	private Sensor_NativePre sensor_NativePre;
	private Sensor_O2 sensor_O2;
	private Sensor_WindSpeed sensor_WindSpeed;
	private Sensor_Dust sensor_Dust;
	private Sensor_LiquidLevel sensor_LiquidLevel;
	private Sensor_WindDoor sensor_WindDoor;
	private Sensor_Unknown sensor_Unknown;
	private Sensor_Smog sensor_Smog;
	private Sensor_Fengtong sensor_Fengtong;
	private Sensor_PekingPower sensor_PekingPower;
	private Sensor_IPD_ZJM sensor_IPD_ZJM;
	public  Sensor creatSenser(byte[] senserData,String gatewayIp) {
		        if(senserData[1]==0x00) { 
			        sensor_CH4_Low = null; 
			        sensor_CH4_Low = new Sensor_CH4_Low(senserData,gatewayIp); 
			        return sensor_CH4_Low;
			        }
		        else if(senserData[1]==0x01) {
			        sensor_CH4_LowHigh = null;
			        sensor_CH4_LowHigh = new Sensor_CH4_LowHigh(senserData,gatewayIp);
			        return sensor_CH4_LowHigh;
		        }
		        else if (senserData[1]==0x03) {
			        sensor_LaserCH4 = null;
			        sensor_LaserCH4 = new Sensor_LaserCH4(senserData,gatewayIp);
			        return sensor_LaserCH4;
		        }
		        else  if(senserData[1]==0x04) {
			        sensor_CO = null;
			        sensor_CO = new Sensor_CO(senserData,gatewayIp);
			        return sensor_CO;
		        }
		        else if (senserData[1]==0x05) {
			        sensor_O2 = null;
			        sensor_O2 = new Sensor_O2(senserData,gatewayIp);
			        return sensor_O2;
		        }
		        else if (senserData[1]==0x06) {
			        sensor_NativePre = null;
			        sensor_NativePre = new Sensor_NativePre(senserData,gatewayIp);
			        return sensor_NativePre;
		        }
		        else if(senserData[1] == 0x07) {
			        sensor_TempHumi = null;
			        sensor_TempHumi = new Sensor_TempHumi(senserData,gatewayIp);
			        return sensor_TempHumi;
		        }
		        else if(senserData[1] == 0x09) {
			        sensor_CO2 = null;
			        sensor_CO2 = new Sensor_CO2(senserData,gatewayIp);
			        return sensor_CO2;
		        }
		        else if(senserData[1]==0x1F) {
			        sensor_Breaker = null;
			        sensor_Breaker = new Sensor_Breaker(senserData,gatewayIp);
			        return sensor_Breaker;
		        }
		        else if(senserData[1]==0x22) {
			        sensor_OpenSwitch = null;
			        sensor_OpenSwitch = new Sensor_OpenSwitch(senserData,gatewayIp);
			        return sensor_OpenSwitch;
		        }
		        else  if(senserData[1]==0x23) {
			        sensor_Power = null;
			        sensor_Power = new Sensor_Power(senserData,gatewayIp);
			        return sensor_Power;
		        }
		        else  if(senserData[1]==0x24) {
			        sensor_CardReader = null;
			        sensor_CardReader = new Sensor_CardReader(senserData,gatewayIp);
			        return sensor_CardReader;
		        }
		        else  if(senserData[1]==0x28) {
			        sensor_BoardCast = null;
			        sensor_BoardCast = new Sensor_BoardCast(senserData,gatewayIp);
			        return sensor_BoardCast;
		        }
		        else if(senserData[1]==0x08) {
			        sensor_WindSpeed = null;
			        sensor_WindSpeed = new Sensor_WindSpeed(senserData,gatewayIp);
			        return sensor_WindSpeed;
		        }
		        else if(senserData[1]==0x0C) {
			        sensor_Dust = null;
			        sensor_Dust = new Sensor_Dust(senserData,gatewayIp);
			        return sensor_Dust;
		        }
		        else if(senserData[1]==0x0C) {
			        sensor_Dust = null;
			        sensor_Dust = new Sensor_Dust(senserData,gatewayIp);
			        return sensor_Dust;
		        }
		        else if(senserData[1]==0x0D) {
			        sensor_LiquidLevel = null;
			        sensor_LiquidLevel = new Sensor_LiquidLevel(senserData,gatewayIp);
			        return sensor_LiquidLevel;
		        }
		        else if(senserData[1]==0x0E) {
			        sensor_Smog = null;
			        sensor_Smog = new Sensor_Smog(senserData,gatewayIp);
			        return sensor_Smog;
		        }
		        else if(senserData[1]==0x0F) {
			        sensor_WindDoor = null;
			        sensor_WindDoor = new Sensor_WindDoor(senserData,gatewayIp);
			        return sensor_WindDoor;
		        }
		        else if(senserData[1]==0x2A) {
			        sensor_Fengtong= null;
			        sensor_Fengtong = new Sensor_Fengtong(senserData,gatewayIp);
			        return sensor_Fengtong;
		        }
		        else if(senserData[1] == 0x38)
		        {
			        sensor_IPD_ZJM = null;
			        sensor_IPD_ZJM = new Sensor_IPD_ZJM(senserData,gatewayIp);
			        return sensor_IPD_ZJM;
		        }
		        else if(senserData[1] == 0x39)
		        {
			        sensor_PekingPower = null;
			        sensor_PekingPower = new Sensor_PekingPower(senserData,gatewayIp);
			        return sensor_PekingPower;
		        }
		        else {
			sensor_Unknown = null;
		        	sensor_Unknown = new Sensor_Unknown(senserData,gatewayIp);
		          return sensor_Unknown;
		        }
	}
	
	public String byteToSenserTypeString(byte type) {
		   if(type ==0x00)
			       return SenserType.SENSERTYPE_CH4LOW;
		        else if(type ==0x01) 
			        return SenserType.SENSERTYPE_CH4HIGHLOW;
		        else if (type==0x03) 
			        return SenserType.SENSERTYPE_LASERCH4;
		        else  if(type==0x04) 
			        return SenserType.SENSERTYPE_CO;
		        else if (type==0x05) 
			        return SenserType.SENSERTYPE_O2;
		        else if (type==0x06) 
			        return SenserType.SENSERTYPE_NATIVEPRE;
		        else if(type== 0x07) 
			        return SenserType.SENSERTYPE_TEMPHUMI;
		        else if(type == 0x09) 
			        return SenserType.SENSERTYPE_CO2;
		        else if(type==0x1F) 
			        return SenserType.SENSERTYPE_BREAKER;
		        else if(type==0x22) 
			        return SenserType.SENSERTYPE_OPENSWITCH;
		        else  if(type==0x23) 
			        return SenserType.SENSERTYPE_POWER;
		        else  if(type==0x24) 
			        return SenserType.SENSERTYPE_CARDREADER;
		        else  if(type==0x28)
			        return SenserType.SENSERTYPE_BOARDCAST;
		        else if(type==0x08) 
			        return SenserType.SENSERTYPE_WindSpeed;
		        else if(type==0x0C) 
			        return SenserType.SENSERTYPE_Dust;
		        else if(type==0x0D) 
			        return SenserType.SENSERTYPE_LIQUIDLEVEL;
		        else if(type==0x0E) 
			        return SenserType.SENSERTYPE_SMOG;
		        else if(type==0x0F) 
			        return SenserType.SENSERTYPE_WINDDOOR;
		        else if(type==0x2A) 
			        return SenserType.SENSERTYPE_Fengtong;
		        else if(type == 0x38)
			        return SenserType.SENSERTYPE_IPD_ZJM;
		        else if(type == 0x39)
			        return SenserType.SENSERTYPE_PKPOWER;
		
		return SenserType.SENSERTYPE_UNKONOW;
	}
}
