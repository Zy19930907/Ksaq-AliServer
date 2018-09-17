package com.zy.net;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import Ali.Ali.App;

public class Server {
	private ServerSocket serverSocket;
	private Socket socket;
	public void listen() {
		try {
			serverSocket = new ServerSocket(12121);
			new Listen().start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public class Listen extends Thread{
		@Override
		public void run() {
			System.out.println("服务启动成功，正在监听端口：12121");
			while(true){
				try {
					socket = serverSocket.accept();
					if(socket != null)
					{
						System.out.println("Cilent link successed");
						System.out.println("Cilent Ip:" + socket.getInetAddress().toString());
						System.out.println("Cilent Port:" + socket.getPort());
						App.sessionManger.CreatIpcSession(socket);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
