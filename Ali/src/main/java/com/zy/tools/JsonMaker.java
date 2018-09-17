package com.zy.tools;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.zy.sendobjs.SendToWanDiao;

public class JsonMaker {
	private GsonBuilder gsonBuilder;
	Gson gson;
	public JsonMaker() {
		gsonBuilder = new GsonBuilder();
		gsonBuilder.setPrettyPrinting();
		gson = gsonBuilder.create();
	}
	
	public String BeanToJsonString(SendToWanDiao sendToWanDiao)
	{
		return gson.toJson(sendToWanDiao);
	}
}
