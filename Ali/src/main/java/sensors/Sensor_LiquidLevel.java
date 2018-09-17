package sensors;

public class Sensor_LiquidLevel extends Sensor{
	public Sensor_LiquidLevel(byte[] senserData,String gatewayIp) {
			SenserName = SenserType.SENSERTYPE_LIQUIDLEVEL;
			initUniversalData(senserData);
			getConcentration(senserData,"m");
}
}
