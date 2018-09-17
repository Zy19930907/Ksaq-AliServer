package com.zy.sessions;

import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class SessionManger {
	private List<IpcSession> sessions = new ArrayList<IpcSession>();

	public void CreatIpcSession(Socket socket){
		IpcSession ipcSession = new IpcSession(socket);
		sessions.add(ipcSession);
	}
}
