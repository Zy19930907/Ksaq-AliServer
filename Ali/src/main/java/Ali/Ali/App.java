package Ali.Ali;

import com.zy.net.Server;
import com.zy.sessions.SessionManger;
import com.zy.tools.DateTool;
import com.zy.tools.LogRecoder;
import com.zy.tools.Redis;

import sensors.SensorFactory;

public class App 
{
	public static SessionManger sessionManger = new SessionManger();
	public static Server server = new Server();
	public static LogRecoder logRecoder = new LogRecoder();
	public static Redis redis = new Redis();
    public static void main( String[] args )
    {
        server.listen();
    }
}
